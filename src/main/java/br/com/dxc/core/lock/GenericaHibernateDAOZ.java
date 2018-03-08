//package br.com.dxc.core.lock;
//
//import gov.pr.celepar.framework.util.Pagina;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.InputStreamReader;
//import java.io.Serializable;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.ParameterizedType;
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.util.Collection;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.persistence.EmbeddedId;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
//import javax.persistence.Transient;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.WordUtils;
//import org.hibernate.CacheMode;
//import org.hibernate.ObjectNotFoundException;
//import org.hibernate.Query;
//import org.hibernate.SQLQuery;
//import org.hibernate.Session;
//import org.hibernate.StaleObjectStateException;
//import org.hibernate.transform.ResultTransformer;
//import org.hibernate.type.StandardBasicTypes;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import br.com.cresol.colmeia.contacorrente.ConstantesContaCorrente;
//import br.com.cresol.colmeia.core.action.facade.BaseFacade;
//import br.com.cresol.colmeia.core.constantes.ConstantesFrame;
//import br.com.cresol.colmeia.core.constantes.Modulo;
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.cresol.colmeia.core.exception.ConcorrenciaException;
//import br.com.cresol.colmeia.core.hibernate.BaseHibernateUtil;
//import br.com.cresol.colmeia.core.util.HibernateUtil;
//import br.com.cresol.colmeia.core.vo.BaseVO;
//import br.com.cresol.colmeia.dao.ParametroPesquisaBuilder.Funcao;
//import br.com.cresol.colmeia.dao.ParametroPesquisaBuilder.Parametro;
//
//import com.mysema.query.jpa.hibernate.HibernateQuery;
//import com.mysema.query.types.OrderSpecifier;
//import com.mysema.query.types.Predicate;
//import com.mysema.query.types.expr.SimpleExpression;
//import com.mysema.query.types.path.EntityPathBase;
//
///**
// * Fun��es m�nimas para DAO utilizando Hibernate
// * 
// * @author Helder Pereira Barb�s
// * @author Ivan Roberto da Silva
// * 
// */
//public abstract class GenericaHibernateDAO<ObjetoVO, identificador extends Serializable>
//		extends BaseDAO<HibernateQuery, Session> implements IGenericaDAO<ObjetoVO, identificador> {
//
//	private static Logger log = LoggerFactory.getLogger(GenericaHibernateDAO.class);
//
//	private Class<ObjetoVO> tipoObjeto;
//
//	private final long BATCH_SIZE = 50;
//
//	public static final String PREFIXO_LOG = "ERRO_COLMEIA_INESPERADO";
//
//	public static final String SEM_PARAMETROS = "SEM PARAMETROS";
//
//	public Class<ObjetoVO> getClassePersistente() {
//
//		return tipoObjeto;
//	}
//
//	public GenericaHibernateDAOZ() {
//
//		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
//			this.tipoObjeto = (Class<ObjetoVO>) ((ParameterizedType) getClass().getGenericSuperclass())
//					.getActualTypeArguments()[0];
//		}
//	}
//
//	/**
//	 * 
//	 * @see br.com.cresol.colmeia.core.dao.IGenericaDAO#salvarAlterar(java.lang.Object)
//	 */
//	public void salvarAlterar(Object vo) throws ApplicationException {
//
//		this.salvarAlterarGenerico(vo);
//	}
//
//	/**
//	 * Respons�vel em salvar objetos genericos
//	 */
//	protected void salvarAlterarGenerico(Object vo) throws ApplicationException {
//
//		try {
//
//			Session session = em.currentSession();
//
//			// deve ser utilizado para que quando for inclus�o os registros
//			// sejam inseridos, pois sen�o o clear remove eles
//			// fun��o: atualiza o que tem na sess�o com o banco
//			session.flush();
//
//			session.evict(vo);
//
//			// limpa os dados inv�lidos que foram atribu�do na sess�o para que
//			// na altera��o estejam compat�veis com o banco
//			// session.clear();
//
//			session.saveOrUpdate(vo);
//		} catch (StaleObjectStateException e) {
//			throw new ConcorrenciaException(Modulo.MODULO_PADRAO, ConstantesFrame.ERRO_STALEOBJECTSTATEEXCEPTION);
//		} catch (Exception e) {
//			log.error(gerarLogError("salvarAlterarGenerico", vo), e);
//
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * 
//	 * @see br.com.cresol.colmeia.core.dao.IGenericaDAO#alterar(java.lang.Object)
//	 */
//	public void alterar(Object vo) throws ApplicationException {
//
//		this.alterarGenerico(vo);
//	}
//
//	/**
//	 * Respons�vel em salvar objetos genericos
//	 */
//	protected void alterarGenerico(Object vo) throws ApplicationException {
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			session.evict(vo);
//
//			session.saveOrUpdate(vo);
//
//		} catch (Exception e) {
//			log.error(gerarLogError("alterarGenerico", vo), e);
//
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * 
//	 * @see br.com.cresol.colmeia.core.dao.IGenericaDAO#carregar(java.lang.Object)
//	 */
//	public ObjetoVO carregar(identificador id) throws ApplicationException {
//
//		ObjetoVO vo = null;
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			if (id == null) {
//				return null;
//			}
//
//			vo = (ObjetoVO) session.get(getClassePersistente(), id);
//		} catch (Exception e) {
//			log.error(gerarLogError("carregar", vo), e);
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//
//		return vo;
//	}
//
//	@SuppressWarnings("unchecked")
//	public <T extends BaseVO> T carregarObjetoSessao(T objeto) {
//		try {
//			Session session = HibernateUtil.currentSession();
//			return (T) session.get(objeto.getClass(), objeto.getChave());
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * 
//	 * @see br.com.cresol.colmeia.core.dao.IGenericaDAO#carregarReferencia(java.lang.Object)
//	 */
//	public ObjetoVO carregarReferencia(identificador id) throws ApplicationException {
//
//		ObjetoVO vo = null;
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			if (id == null) {
//				return null;
//			}
//
//			vo = (ObjetoVO) session.load(getClassePersistente(), id);
//		} catch (ObjectNotFoundException e) {
//			return null;
//		} catch (Exception e) {
//			log.error(gerarLogError("carregarReferencia", vo), e);
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//
//		return vo;
//	}
//
//	/**
//	 * @deprecated {@link GenericaHibernateDAO#carregarReferencia(EntityPathBase, Predicate...)}
//	 */
//	@Deprecated
//	public <T extends BaseVO> T carregarReferencia(Class<T> classe, ParametroPesquisa parametroPesquisa)
//			throws ApplicationException {
//		T retorno = null;
//
//		try {
//			Serializable id = this.carregarId(classe, parametroPesquisa);
//
//			if (id == null) {
//				return null;
//			}
//
//			Session session = HibernateUtil.currentSession();
//
//			retorno = (T) session.load(classe, id);
//		} catch (ObjectNotFoundException e) {
//			return null;
//		} catch (Exception e) {
//			log.error(gerarLogError("carregarReferencia", classe, parametroPesquisa), e);
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//
//		return retorno;
//	}
//
//	/**
//	 * Carrega uma referencia a um objeto buscando por predicados (clausulas no
//	 * where)
//	 * 
//	 * @param entidade
//	 * @param predicates
//	 * @return
//	 * @throws ApplicationException
//	 */
//	@SuppressWarnings("unchecked")
//	public <T extends BaseVO> T carregarReferencia(final EntityPathBase<T> entidade, Predicate... predicates)
//			throws ApplicationException {
//		try {
//			Serializable id = carregarId(entidade, false, null, predicates);
//			if (id == null) {
//				return null;
//			}
//
//			Session session = HibernateUtil.currentSession();
//
//			return (T) session.load(entidade.getType(), id);
//		} catch (ObjectNotFoundException e) {
//			return null;
//		} catch (Exception e) {
//			log.error(gerarLogError("carregarReferencia", entidade, predicates));
//			throw new ApplicationException(e);
//		} catch (Throwable t) {
//			log.error(gerarLogError("carregarReferencia", entidade, predicates));
//			t.printStackTrace();
//			throw new ApplicationException(t);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * @deprecated {@link GenericaHibernateDAO#carregarId(EntityPathBase, Boolean, String, Predicate...)}
//	 */
//	@Deprecated
//	public <T extends Serializable> T carregarId(Class classe, ParametroPesquisa parametroPesquisa)
//			throws ApplicationException {
//
//		return this.carregarId(classe, parametroPesquisa, false, null);
//	}
//
//	/**
//	 * @deprecated {@link GenericaHibernateDAO#carregarId(EntityPathBase, Boolean, String, Predicate...)}
//	 */
//	@Deprecated
//	public <T extends Serializable> T carregarId(final Class classe, final ParametroPesquisa parametroPesquisa,
//			final Boolean cacheable, final String cacheRegion) throws ApplicationException {
//
//		T retorno = null;
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			String campoId = null;
//			for (Field field : classe.getDeclaredFields()) {
//				if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class)) {
//					campoId = field.getName();
//					break;
//				}
//			}
//
//			StringBuffer hql = new StringBuffer();
//			hql.append(" select c.").append(campoId).append(" from ").append(classe.getSimpleName()).append(" c ");
//			hql.append(" where 1 = 1 ");
//
//			String hqlWhere = this.montarClausulaHQLParametroPesquisa(parametroPesquisa);
//			hql.append(hqlWhere);
//
//			Query query = session.createQuery(hql.toString());
//
//			this.preencherParametroPesquisa(query, parametroPesquisa);
//
//			query.setReadOnly(true);
//			query.setCacheable(cacheable);
//
//			if (cacheable && !StringUtils.isEmpty(cacheRegion)) {
//				query.setCacheRegion(cacheRegion);
//			}
//
//			retorno = (T) query.uniqueResult();
//
//		} catch (ObjectNotFoundException e) {
//			return null;
//		} catch (Exception e) {
//			log.error(gerarLogError("carregarId", classe, parametroPesquisa), e);
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//
//		return retorno;
//	}
//
//	private String montarClausulaHQLParametroPesquisa(ParametroPesquisa parametroPesquisa) {
//		StringBuffer hqlWhere = new StringBuffer();
//
//		int indice = 0;
//
//		for (String campo : parametroPesquisa.getParametros().keySet()) {
//
//			Object valor = parametroPesquisa.getParametros().get(campo);
//
//			Funcao funcao = parametroPesquisa.getParametrosFuncao().get(campo);
//
//			if (valor != null) {
//
//				if (valor instanceof Parametro && Parametro.IS_NULL.equals(valor)) {
//					hqlWhere.append(" and c.").append(campo).append(" is null ");
//				} else if (valor instanceof Parametro && Parametro.INEXISTENTE.equals(valor)) {
//					hqlWhere.append(" and c.").append(campo);
//				} else if (valor instanceof Collection) {
//					hqlWhere.append(" and c.").append(campo).append(" in (:param").append(indice).append(")");
//				} else if (valor instanceof String && StringUtils.isEmpty((String) valor)) {
//					indice++;
//
//					continue;
//				} else if (valor instanceof Pagina) {
//					indice++;
//
//					continue;
//				} else {
//					if (funcao == null) {
//						hqlWhere.append(" and c.").append(campo).append(" = :param").append(indice);
//					} else {
//						hqlWhere.append(" and ").append(funcao.getNomeFuncao()).append("(c.").append(campo).append(")")
//								.append(" = :param").append(indice);
//					}
//				}
//
//				indice++;
//			}
//		}
//
//		StringBuffer hqlOrderBy = new StringBuffer();
//
//		for (String campo : parametroPesquisa.getOrderBy()) {
//			if (hqlOrderBy.length() == 0) {
//				hqlOrderBy.append(" order by ");
//			} else {
//				hqlOrderBy.append(", ");
//			}
//			hqlOrderBy.append("c.").append(campo);
//		}
//
//		return hqlWhere.append(hqlOrderBy).toString();
//	}
//
//	private void preencherParametroPesquisa(Query query, ParametroPesquisa parametroPesquisa) {
//
//		int indice = 0;
//		Pagina pagina = null;
//
//		for (String campo : parametroPesquisa.getParametros().keySet()) {
//			Object valor = parametroPesquisa.getParametros().get(campo);
//
//			if (valor != null && !(valor instanceof Parametro)) {
//				if (valor instanceof Collection) {
//					query.setParameterList("param" + indice, (Collection) valor);
//				} else if (valor instanceof Pagina) {
//					pagina = (Pagina) valor;
//				} else if (valor instanceof String && StringUtils.isEmpty((String) valor)) {
//					indice++;
//
//					continue;
//				} else {
//					query.setParameter("param" + indice, valor);
//				}
//				indice++;
//			}
//		}
//
//		if (pagina != null && pagina.getQuantidade() != null && pagina.getPaginaAtual() != null) {
//			controlePaginacaoDAO(pagina.getQuantidade(), pagina.getPaginaAtual(), query);
//		}
//	}
//
//	/**
//	 * Monta o select e os joins necess�rios pra pesquisa de acordo com os campos
//	 * solicitados
//	 * 
//	 * @param <T>
//	 * @param classe
//	 * @param campos
//	 * @return
//	 * @throws ApplicationException
//	 * @throws Exception
//	 */
//	protected <T extends Object> String montarCampos(final Class<T> classe, final String... campos)
//			throws ApplicationException, Exception {
//
//		Class classePai = classe.getSuperclass();
//
//		StringBuffer hqlCampos = new StringBuffer();
//		StringBuffer hqlLeftJoin = new StringBuffer();
//		for (String campo : campos) {
//			String alias = "c.";
//
//			Field field = null;
//			try {
//				field = classe.getDeclaredField(campo);
//			} catch (NoSuchFieldException e) {
//				field = classePai.getDeclaredField(campo);
//			}
//
//			if (BaseVO.class.isAssignableFrom(field.getType())) {
//				if (field.isAnnotationPresent(JoinColumn.class)) {
//					JoinColumn joinColumn = field.getAnnotation(JoinColumn.class);
//					if (joinColumn.nullable()) {
//						hqlLeftJoin.append(" left join c.").append(campo).append(" ").append(campo);
//						alias = "";
//					}
//				} else if (field.isAnnotationPresent(JoinColumns.class)) {
//					JoinColumns joinColumns = field.getAnnotation(JoinColumns.class);
//					for (JoinColumn joinColumn : joinColumns.value()) {
//						if (joinColumn.nullable()) {
//							hqlLeftJoin.append(" left join c.").append(campo).append(" ").append(campo);
//							alias = "";
//							break;
//						}
//					}
//				}
//			}
//
//			if (hqlCampos.toString().length() > 0) {
//				hqlCampos.append(", ");
//			}
//			hqlCampos.append(alias).append(campo).append(" as ").append(campo);
//		}
//
//		if (campos == null || campos.length == 0) {
//			hqlCampos.append("c");
//		}
//
//		StringBuffer hql = new StringBuffer();
//		hql.append("select ").append(hqlCampos.toString()).append(" from ").append(classe.getSimpleName())
//				.append(" c ");
//		hql.append(hqlLeftJoin);
//
//		return hql.toString();
//	}
//
//	/**
//	 * Buscar recursivamente na hierarquia o campo que � o ID
//	 * 
//	 * @param classe
//	 * @return
//	 */
//	private Field buscarFieldId(Class<?> classe) {
//		for (Field field : classe.getDeclaredFields()) {
//			if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class)) {
//				return field;
//			}
//		}
//		if (classe.getSuperclass() != null) {
//			return buscarFieldId(classe.getSuperclass());
//		}
//		return null;
//	}
//
//	/**
//	 * @deprecated {@link GenericaHibernateDAO#carregarCampos(EntityPathBase, Serializable, SimpleExpression...)}
//	 */
//	@Deprecated
//	public <T extends Object> T carregarCampos(final Class<T> classe, final Serializable id, final String... campos)
//			throws ApplicationException {
//
//		return this.carregarCampos(classe, false, null, id, null, campos);
//	}
//
//	/**
//	 * @deprecated {@link GenericaHibernateDAO#carregarCampos(EntityPathBase, Boolean, String, Serializable, SimpleExpression...)}
//	 */
//	@Deprecated
//	public <T extends Object> T carregarCampos(final Class<T> classe, final Boolean cacheable, final String cacheRegion,
//			final Serializable id, final ParametroPesquisa parametroPesquisa, final String... campos)
//			throws ApplicationException {
//
//		T vo = null;
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			StringBuffer hql = new StringBuffer();
//			hql.append(this.montarCampos(classe, campos));
//
//			final Class classePai = classe.getSuperclass();
//
//			Field fieldId = this.buscarFieldId(classe);
//			if (fieldId == null) {
//				fieldId = this.buscarFieldId(classePai);
//			}
//
//			final String campoIdFinal = fieldId.getName();
//			final Class classeCampoIdFinal = fieldId.getType();
//
//			if (parametroPesquisa == null) {
//				hql.append(" where c.").append(fieldId.getName()).append(" = :id ");
//			} else {
//				hql.append(" where 1 = 1 ");
//
//				String hqlWhere = this.montarClausulaHQLParametroPesquisa(parametroPesquisa);
//				hql.append(hqlWhere);
//			}
//
//			Query query = session.createQuery(hql.toString());
//
//			if (parametroPesquisa == null) {
//				query.setParameter("id", id);
//			} else {
//				this.preencherParametroPesquisa(query, parametroPesquisa);
//			}
//
//			if (campos != null && campos.length > 0) {
//				query.setResultTransformer(new ResultTransformer() {
//
//					private static final long serialVersionUID = 1L;
//
//					/**
//					 * Transforma o result set na entidade que foi solicitada
//					 */
//					public Object transformTuple(Object[] valores, String[] alias) {
//						try {
//							Object vo = classe.newInstance();
//
//							for (int i = 0; i < valores.length; i++) {
//								setaValor(vo, campos[i], valores[i]);
//							}
//							setaValor(vo, campoIdFinal, classeCampoIdFinal, id);
//
//							return vo;
//						} catch (Exception e) {
//							e.printStackTrace();
//							return null;
//						}
//					}
//
//					/**
//					 * Preenche o valor na entidade atraves de reflex�o
//					 */
//					private void setaValor(Object vo, String campo, Object valor) throws Exception {
//						this.setaValor(vo, campo, null, valor);
//					}
//
//					/**
//					 * Preenche o valor na entidade atraves de reflex�o
//					 */
//					private void setaValor(Object vo, String campo, Class classeValor, Object valor) throws Exception {
//						if (valor != null) {
//							Field field = null;
//							try {
//								field = classe.getDeclaredField(campo);
//							} catch (NoSuchFieldException e) {
//								field = classePai.getDeclaredField(campo);
//							}
//
//							Method metodo = classe.getMethod("set" + WordUtils.capitalize(campo),
//									classeValor == null ? field.getType() : classeValor);
//							metodo.invoke(vo, valor);
//						}
//					}
//
//					public List transformList(List list) {
//						return list;
//					}
//				});
//			}
//
//			query.setReadOnly(true);
//			query.setCacheable(cacheable);
//
//			if (cacheable && !StringUtils.isEmpty(cacheRegion)) {
//				query.setCacheRegion(cacheRegion);
//			}
//
//			vo = (T) query.uniqueResult();
//
//		} catch (Exception e) {
//			log.error(gerarLogError("carregarCampos", classe, id, campos), e);
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//
//		return vo;
//	}
//
//	public <T extends Object> List<T> pesquisarCampos(final Class<T> classe, final ParametroPesquisa parametroPesquisa,
//			boolean cacheable, final String... campos) throws ApplicationException {
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			StringBuffer hql = new StringBuffer();
//			hql.append(this.montarCampos(classe, campos));
//
//			final Class classePai = classe.getSuperclass();
//
//			Field fieldId = this.buscarFieldId(classe);
//			if (fieldId == null) {
//				fieldId = this.buscarFieldId(classePai);
//			}
//
//			hql.append(" where 1 = 1 ");
//
//			String hqlWhere = this.montarClausulaHQLParametroPesquisa(parametroPesquisa);
//			hql.append(hqlWhere);
//
//			Query query = session.createQuery(hql.toString());
//			this.preencherParametroPesquisa(query, parametroPesquisa);
//
//			query.setResultTransformer(new ResultTransformer() {
//
//				private static final long serialVersionUID = 1L;
//
//				/**
//				 * Transforma o result set na entidade que foi solicitada
//				 */
//				public Object transformTuple(Object[] valores, String[] alias) {
//					try {
//						Object vo = classe.newInstance();
//
//						for (int i = 0; i < valores.length; i++) {
//							setaValor(vo, campos[i], valores[i]);
//						}
//
//						return vo;
//					} catch (Exception e) {
//						e.printStackTrace();
//						return null;
//					}
//				}
//
//				/**
//				 * Preenche o valor na entidade atraves de reflex�o
//				 */
//				private void setaValor(Object vo, String campo, Object valor) throws Exception {
//					this.setaValor(vo, campo, null, valor);
//				}
//
//				/**
//				 * Preenche o valor na entidade atraves de reflex�o
//				 */
//				private void setaValor(Object vo, String campo, Class classeValor, Object valor) throws Exception {
//					if (valor != null) {
//						Field field = null;
//						try {
//							field = classe.getDeclaredField(campo);
//						} catch (NoSuchFieldException e) {
//							field = classePai.getDeclaredField(campo);
//						}
//
//						Method metodo = classe.getMethod("set" + WordUtils.capitalize(campo),
//								classeValor == null ? field.getType() : classeValor);
//						metodo.invoke(vo, valor);
//					}
//				}
//
//				public List transformList(List list) {
//					return list;
//				}
//			});
//
//			query.setReadOnly(true);
//			query.setCacheable(cacheable);
//
//			return query.list();
//		} catch (Exception e) {
//			log.error(gerarLogError("pesquisarCampos", classe, parametroPesquisa, campos), e);
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * 
//	 * @see br.com.cresol.colmeia.core.dao.IGenericaDAO#carregarReferencia(java.lang.Object)
//	 */
//	public <T extends BaseVO> T carregarReferencia(Class<T> classe, Serializable id) throws ApplicationException {
//
//		T vo = null;
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			if (id == null) {
//				return null;
//			}
//
//			vo = (T) session.load(classe, id);
//		} catch (ObjectNotFoundException e) {
//			return null;
//		} catch (Exception e) {
//			log.error(gerarLogError("carregarReferencia", vo), e);
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//
//		return vo;
//	}
//
//	/**
//	 * 
//	 * @see br.com.cresol.colmeia.core.dao.IGenericaDAO#excluirEventoMovimentoTransitoria(java.lang.Object)
//	 */
//	public void excluir(Object vo) throws ApplicationException {
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			session.delete(vo);
//
//		} catch (Exception e) {
//			log.error(gerarLogError("excluir", vo));
//
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * 
//	 * @see br.com.cresol.colmeia.core.dao.IGenericaDAO#incluir(java.lang.Object)
//	 */
//	public void incluir(Object vo) throws ApplicationException {
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			session.save(vo);
//
//		} catch (Exception e) {
//			log.error(gerarLogError("incluir", vo), e);
//
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * M�todo que dever� ser utilizado por quaisquer VO's que n�o fa�am parte da
//	 * estrutura do Generics do Projeto
//	 * 
//	 * @param vo
//	 * @throws ApplicationException
//	 */
//	public void incluirObjeto(BaseVO vo) throws ApplicationException {
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			session.save(vo);
//
//		} catch (Exception e) {
//			log.error(gerarLogError("incluirObjeto", vo), e);
//
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * M�todo que dever� ser utilizado por quaisquer VO's que n�o fa�am parte da
//	 * estrutura do Generics do Projeto
//	 * 
//	 * @param vo
//	 * @throws ApplicationException
//	 * @throws Exception
//	 */
//	public void excluirObjeto(BaseVO vo) throws ApplicationException {
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			session.delete(vo);
//
//		} catch (Exception e) {
//			log.error(gerarLogError("excluirObjeto", vo), e);
//
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * M�todo respons�vel em fazer o controle dos select para pagina��o
//	 * 
//	 * @param qtdPagina
//	 *            Quantide por p�gina
//	 * @param numPagina
//	 *            Numero da pagina atual
//	 * @param q
//	 *            Query
//	 */
//	protected void controlePaginacaoDAO(final Integer qtdPagina, final Integer numPagina, final Query q) {
//
//		if (qtdPagina != null && numPagina != null) {
//			q.setMaxResults(qtdPagina.intValue());
//			q.setFirstResult(((numPagina.intValue() - 1) * qtdPagina.intValue()));
//		}
//	}
//
//	/**
//	 * Realiza o controle de pagina��o das consultas utilizando QueryDSL
//	 * 
//	 * @param qtdPagina
//	 *            Quantidade de registro por pagina
//	 * @param numPagina
//	 *            Numero da pagina
//	 * @param query
//	 */
//	protected void controlePaginacaoDAO(final Integer qtdPagina, final Integer numPagina, final HibernateQuery query) {
//
//		if (qtdPagina != null && numPagina != null) {
//			query.limit(qtdPagina).offset((numPagina.intValue() - 1) * qtdPagina.intValue());
//		}
//	}
//
//	/**
//	 * M�todo utilizado para fazer, inserts em batch no hibernate, com m�xima
//	 * performance atrav�s de uma Collection de ObjetoVO passada por par�metro
//	 * 
//	 * @param listaPersistente
//	 * @throws ApplicationException
//	 */
//	public <T extends BaseVO> void salvarBatch(Collection<T> listaPersistente) throws ApplicationException {
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			// Ignora o cache de segundo nivel
//			session.setCacheMode(CacheMode.IGNORE);
//
//			HibernateUtil.currentTransaction();
//
//			long i = 0;
//			for (BaseVO objetoAtual : listaPersistente) {
//				i++;
//				session.saveOrUpdate(objetoAtual);
//				onProcessarBatch(objetoAtual);
//				if (i % BATCH_SIZE == 0) {
//					session.flush();
//					session.clear();
//				}
//			}
//			HibernateUtil.commitTransaction();
//
//			onFinalBatch(listaPersistente);
//
//		} catch (Exception e) {
//			HibernateUtil.rollbackTransaction();
//
//			log.error(gerarLogError("salvarBatch", listaPersistente), e);
//
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * Stub. Pode ser sobrescrito para efetuar algum processamento posterior ao
//	 * SalvarBatch
//	 * 
//	 * @param listaPersistente
//	 */
//	public <T extends BaseVO> void onFinalBatch(Collection<T> listaPersistente) {
//		// Stub. Pode ser sobrescrito para efetuar algum processamento posterior
//		// ao SalvarBatch
//	}
//
//	/**
//	 * Stub. Pode ser sobrescrito para efetuar algum processamento durante cada
//	 * linha do batch
//	 * 
//	 * @param objetoAtual
//	 */
//	public <T> void onProcessarBatch(T objetoAtual) {
//		// Stub. Pode ser sobrescrito para efetuar algum processamento durante
//		// cada linha do batch
//	}
//
//	/**
//	 * Retorna true se o elemento for do tipo String
//	 * 
//	 * @param <E>
//	 * @param elemento
//	 * @return Boolean
//	 */
//
//	private <E> Boolean isSql(E elemento) {
//		return elemento instanceof String;
//	}
//
//	/**
//	 * Responsavel por montar o string sql ou a query do hibernate.
//	 * 
//	 * @param <E>
//	 *            - o tipo do elemento, pode ser um Query ou um String
//	 * @param object
//	 *            - o objeto VO de valor
//	 * @param elemento
//	 *            - o tipo do elemento, pode ser um Query ou um String
//	 * @param var
//	 *            - Caso tenha um objeto dentro do passado como elemento String para
//	 *            <E>, obter do mapa o String automaticamente.
//	 * @param Map
//	 *            <String, Object []> mapa - onde chave � um contador sequencial e
//	 *            Object [] na primeira posicao representa o sql, e na segunda
//	 *            posicao representa o objeto de valor
//	 * @return O elemento passado - Query ou String
//	 */
//	private <E> E pesquisar(Object object, E elemento, String var, Map<String, Object[]> mapa) {
//
//		Query consulta = null;
//		String sql = null;
//
//		Boolean isSql = isSql(elemento);
//
//		if (!isSql) {
//			consulta = (Query) elemento;
//		} else {
//			sql = (String) elemento;
//		}
//
//		int i = 0;
//
//		Class<?> classe = (Class<?>) object.getClass();
//
//		for (Field atributo : classe.getDeclaredFields()) {
//
//			boolean annotation = atributo.isAnnotationPresent(Transient.class);
//
//			if (annotation) {
//				continue;
//			}
//
//			String nome = atributo.getName();
//			String metodo = "get" + nome.substring(0, 1).toUpperCase() + nome.substring(1);
//			try {
//
//				Object resultado = classe.getMethod(metodo).invoke(object);
//
//				if (resultado == null) {
//					continue;
//				}
//
//				if (resultado instanceof Collection) {
//
//					Collection colObject = (Collection) resultado;
//
//					if (colObject.isEmpty()) {
//						continue;
//					}
//				}
//
//				Class<?> type = atributo.getType();
//
//				boolean primitive = type.isPrimitive();
//
//				String nomeTipo = type.getName();
//
//				if (nomeTipo.indexOf("$") != -1) {
//					continue;
//				}
//
//				if (!isSql) {
//					if (primitive ? "int".equals(nomeTipo) : "java.lang.Integer".equals(nomeTipo)) {
//						consulta.setInteger(nome, (Integer) resultado);
//					} else if ("java.math.BigDecimal".equals(nomeTipo)) {
//						consulta.setBigDecimal(nome, (BigDecimal) resultado);
//					} else if (primitive ? "long".equals(nomeTipo) : "java.lang.Long".equals(nomeTipo)) {
//						consulta.setLong(nome, (Long) resultado);
//					} else if ("java.lang.String".equals(nomeTipo)) {
//						consulta.setString(nome, (String) resultado);
//					} else if ("java.util.Collection".equals(nomeTipo)) {
//						consulta.setParameterList(nome, (Collection<?>) resultado);
//					} else if (primitive ? "boolean".equals(nomeTipo) : "java.lang.Boolean".equals(nomeTipo)) {
//						consulta.setBoolean(nome, (Boolean) resultado);
//					} else {
//						mapa.put(String.valueOf(++i), new Object[] { (var + nome).trim(), resultado });
//					}
//
//				} else if ((primitive ? "int".equals(nomeTipo) : "java.lang.Integer".equals(nomeTipo))
//						|| "java.math.BigDecimal".equals(nomeTipo)
//						|| (primitive ? "long".equals(nomeTipo) : "java.lang.Long".equals(nomeTipo))
//						|| "java.lang.String".equals(nomeTipo) || "java.util.Collection".equals(nomeTipo)
//						|| (primitive ? "boolean".equals(nomeTipo) : "java.lang.Boolean".equals(nomeTipo))) {
//					sql += " and atributo." + (var + nome).trim() + " = :" + nome.trim();
//				} else {
//					mapa.put(String.valueOf(++i), new Object[] { (var + nome).trim(), resultado });
//				}
//			} catch (Exception e) {
//				continue;
//			}
//		}
//
//		elemento = !isSql ? (E) consulta : (E) sql;
//
//		return elemento;
//	}
//
//	/**
//	 * Use esta funcao quando precisar fazer uma pesquisa.
//	 * 
//	 * @param <E>
//	 * @param object
//	 *            - objeto de valor
//	 * @param elemento
//	 *            - pode ser uma Query ou um String.
//	 * @return
//	 */
//	protected <E> E pesquisarObjeto(Object object, E elemento) {
//
//		Map<String, Object[]> mapa = new HashMap<String, Object[]>();
//
//		elemento = pesquisar(object, elemento, "", mapa);
//
//		for (Object[] objects : mapa.values()) {
//			elemento = pesquisar(objects[1], elemento, (String) objects[0] + ".", mapa);
//		}
//
//		return elemento;
//	}
//
//	/**
//	 * 
//	 * Use esta fun��o para montar o select de campos do VO em um m�todo de pesquisa
//	 * com performance.
//	 * 
//	 * @param sb
//	 * @param separador
//	 * @param clausula
//	 * @param carregaCampo
//	 * @param primeiroCampo
//	 * @return
//	 */
//	protected boolean montarCamposSelect(StringBuffer sb, String separador, String clausula, boolean carregaCampo,
//			boolean primeiroCampo) {
//		if (carregaCampo) {
//			if (!primeiroCampo) {
//				sb.append(separador);
//			} else {
//				primeiroCampo = false;
//			}
//			sb.append(clausula);
//		}
//		return primeiroCampo;
//
//	}
//
//	public static String gerarLogError(String nomeMetodo, Object... parametros) {
//
//		StringBuilder log = new StringBuilder(PREFIXO_LOG);
//		log.append(": ");
//		log.append(nomeMetodo);
//		log.append("(");
//
//		if (parametros != null && parametros.length > 0) {
//
//			for (int i = 0; i < parametros.length; i++) {
//
//				if ((parametros.length - 1) != i) {
//					log.append(parametros[i]);
//					log.append(", ");
//				} else {
//					log.append(parametros[i]);
//				}
//			}
//		} else {
//			log.append(SEM_PARAMETROS);
//		}
//
//		log.append(")");
//
//		return log.toString();
//	}
//
//	/**
//	 * M�todo utilit�rio criado para execu��o de scripts sql nativo de carga e
//	 * limpeza dos dados. Utilizado nos testes com Selenium.
//	 * 
//	 * @param pathArquivoScript
//	 * @throws ApplicationException
//	 * @throws Exception
//	 */
//	public void executarScriptSQL(String pathArquivoScript) throws ApplicationException, Exception {
//		Connection con = null;
//		try {
//
//			con = ConnectionFactory.getConnection();
//
//			PreparedStatement ps = con.prepareStatement(obterScriptsArquivo(pathArquivoScript));
//
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ApplicationException(e);
//		} finally {
//			con.close();
//		}
//	}
//
//	/**
//	 * Gera o arquivo de scripts no formato .sql no destino informado no
//	 * pathArquivoScript a partir dos dados contidos no arquivo informado no
//	 * pathArquivoLog. Utilizado nos testes com Selenium.
//	 * 
//	 * @param pathArquivoLog
//	 * @param pathArquivoScript
//	 * @throws ApplicationException
//	 * @throws Exception
//	 */
//	public void gerarArquivoScriptSQL(String pathArquivoLog, String pathArquivoScript)
//			throws ApplicationValidatorException, Exception {
//		// concatena o caminho do arquivo a partir do diretorio do usuario
//		pathArquivoScript = System.getProperty("user.dir") + pathArquivoScript;
//
//		/*
//		 * Devido a problemas devido ao charset dos arquivos de leitura, utiliza o
//		 * encoding. Verificar se foi inclu�do caracteres n�o esperados no in�cio da
//		 * primeira linha.
//		 */
//		String encoding = "UTF-8";
//
//		// arquivo de leitura
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathArquivoLog), encoding));
//
//		// arquivo de escrita
//		BufferedWriter bw = new BufferedWriter(new FileWriter(pathArquivoScript));
//
//		String linha;
//		String script;
//		String[] vet;
//
//		// enquanto houver linhas no arquivo
//		while ((linha = br.readLine()) != null) {
//			// verifica se a linha possui scripts a serem executados
//			if (linha.contains("insert") || linha.contains("update") || linha.contains("delete")) {
//				// separa o conteudo da linha em partes
//				vet = linha.split("\\|");
//
//				// a ultima posicao do vetor contem o script a ser executado
//				script = vet[vet.length - 1];
//
//				// substitui '' por null, nem todos valores sao string
//				script = script.replace("''", "null");
//
//				// grava o script no arquivo
//				bw.write(script.concat(";\n"));
//			}
//		}
//
//		bw.close();
//	}
//
//	/**
//	 * Obtem os scripts a partir do arquivo informado. Utilizado nos testes com
//	 * Selenium.
//	 * 
//	 * @param pathArquivoScript
//	 * @throws Exception
//	 */
//	private String obterScriptsArquivo(String pathArquivoScript) throws Exception {
//		// concatena o caminho do arquivo a partir do diretorio do usuario
//		pathArquivoScript = System.getProperty("user.dir") + pathArquivoScript;
//
//		/*
//		 * Devido a problemas devido ao charset dos arquivos de leitura, utiliza o
//		 * encoding.
//		 */
//		String encoding = "UTF-8";
//
//		// carrega o arquivo de script
//		BufferedReader bufferedReader = new BufferedReader(
//				new InputStreamReader(new FileInputStream(pathArquivoScript), encoding));
//
//		String linha;
//		StringBuilder scripts = new StringBuilder();
//
//		// enquanto houver linhas no arquivo
//		while ((linha = bufferedReader.readLine()) != null) {
//			scripts.append(linha);
//		}
//
//		return scripts.toString();
//	}
//
//	/**
//	 * M�todo respons�vel em substituir determinados parametros antes da execu��o de
//	 * um script (insert, update, delete..) na base de dados
//	 * 
//	 * @param script
//	 * @param parametros
//	 * @return
//	 */
//	protected String substituirParametrosScript(String script, Object... parametros) {
//
//		String novoStript = script;
//
//		if (parametros != null && parametros.length > 0) {
//
//			for (int i = 0; i < parametros.length; i++) {
//				novoStript = novoStript.replaceAll("#" + (i + 1), parametros[i].toString());
//			}
//		}
//
//		return novoStript;
//	}
//
//	
//
//	public <T extends Serializable> T carregarIdPrimeiro(Class classe, ParametroPesquisa parametroPesquisa)
//			throws ApplicationException {
//
//		T retorno = null;
//
//		try {
//
//			Session session = HibernateUtil.currentSession();
//
//			String campoId = null;
//
//			for (Field field : classe.getDeclaredFields()) {
//				if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class)) {
//					campoId = field.getName();
//					break;
//				}
//			}
//
//			StringBuffer hql = new StringBuffer();
//			hql.append(" select c.").append(campoId).append(" from ").append(classe.getSimpleName()).append(" c ");
//			hql.append(" where 1 = 1 ");
//
//			String hqlWhere = this.montarClausulaHQLParametroPesquisa(parametroPesquisa);
//			hql.append(hqlWhere);
//
//			Query query = session.createQuery(hql.toString()).setMaxResults(1);
//			this.preencherParametroPesquisa(query, parametroPesquisa);
//
//			query.setReadOnly(true);
//
//			retorno = (T) query.uniqueResult();
//		} catch (ObjectNotFoundException e) {
//			return null;
//		} catch (Exception e) {
//			log.error(gerarLogError("carregarIdPrimeiro", classe, parametroPesquisa), e);
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//
//		return retorno;
//	}
//
//	public <T extends Object> List<T> pesquisarCampos(final EntityPathBase<T> entidade, final Boolean cacheable,
//			final String cacheRegion, SimpleExpression<?>[] campos, Predicate... predicates)
//			throws ApplicationException {
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			return pesquisarCampos(session, (EntityPathBase<T>) entidade, cacheable, cacheRegion, campos,
//					new OrderSpecifier<?>[] {}, predicates);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	public <T extends Object> List<T> pesquisarCampos(final EntityPathBase<T> entidade, final Boolean cacheable,
//			final String cacheRegion, SimpleExpression<?>[] campos, OrderSpecifier<?>[] camposOrdenacao,
//			Predicate... predicates) throws ApplicationException {
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			return pesquisarCampos(session, entidade, cacheable, cacheRegion, campos, camposOrdenacao, predicates);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	public <T, R extends Serializable> R carregarId(EntityPathBase<T> entidade, Boolean cacheable, String cacheRegion,
//			Predicate... predicates) throws ApplicationException {
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			return carregarId(session, entidade, cacheable, cacheRegion, predicates);
//		} catch (ObjectNotFoundException e) {
//			return null;
//		} catch (Exception e) {
//			log.error(gerarLogError("carregarId", entidade, cacheable, cacheRegion, predicates));
//			throw new ApplicationException(e);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	public <T extends Object> T carregarCampos(final EntityPathBase<T> entidade, final Boolean cacheable,
//			final String cacheRegion, final Serializable id, Predicate[] predicates, SimpleExpression<?>... campos)
//			throws ApplicationException {
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			return carregarCampos(session, entidade, cacheable, cacheRegion, id, predicates, campos);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	@Override
//	public HibernateQuery obterQuery(Session entityManager, Boolean cacheable, String cacheRegion) {
//		cacheable = cacheable != null ? cacheable : false;
//		return new HibernateQuery(entityManager).setCacheable(cacheable).setCacheRegion(cacheRegion);
//	}
//
//	/**
//	 * @see br.com.cresol.colmeia.dao.IGenericaDAO#carregarAtrasoReplicacao(java.lang.String,
//	 *      java.lang.String)
//	 */
//	@Override
//	public Long carregarAtrasoReplicacao(String ip, String nome) {
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			SQLQuery query = session
//					.createSQLQuery("select pg_replication_slave_delay(cast(:ip as inet), :nome) as atraso ");
//			query.setParameter("ip", ip);
//			query.setParameter("nome", nome);
//
//			query.addScalar("atraso", StandardBasicTypes.LONG);
//
//			return (Long) query.uniqueResult();
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * @see br.com.cresol.colmeia.dao.IGenericaDAO#carregarAtrasoTempoReplicacao(java.lang.Class)
//	 */
//	@Override
//	public Integer carregarAtrasoTempoReplicacao(Class<? extends BaseHibernateUtil> implementation) {
//		try {
//			HibernateUtil.changeImplementation(implementation);
//
//			Session session = HibernateUtil.currentSession();
//
//			SQLQuery query = session.createSQLQuery(
//					"select extract(epoch from now() - timestamp) as atraso from  pg_last_committed_xact() ");
//
//			query.addScalar("atraso", StandardBasicTypes.INTEGER);
//
//			return (Integer) query.uniqueResult();
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * @see BaseFacade#verificarExistenciaRegistros(EntityPathBase, Predicate...)
//	 */
//	public <T extends Object> Boolean verificarExistenciaRegistros(final EntityPathBase<T> entidade,
//			Predicate... predicates) throws ApplicationException {
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			return verificarExistenciaRegistros(session, entidade, predicates);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * @see BaseFacade#pesquisarRegistrosPagina(Pagina, EntityPathBase,
//	 *      SimpleExpression[], OrderSpecifier[], Predicate...)
//	 */
//	public <T extends Object> void pesquisarRegistrosPagina(Pagina pagina, final EntityPathBase<T> entidade,
//			SimpleExpression<?>[] campos, OrderSpecifier<?>[] camposOrdenacao, Predicate... predicates)
//			throws ApplicationException {
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			pesquisarRegistrosPagina(pagina, session, entidade, campos, camposOrdenacao, predicates);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * @see BaseFacade#carregarCampo(EntityPathBase, Serializable, SimpleExpression,
//	 *      Predicate...)
//	 */
//	public <T extends Object> Object carregarCampo(final EntityPathBase<T> entidade, final Serializable id,
//			SimpleExpression<?> campo, Predicate... predicates) throws ApplicationException {
//
//		try {
//			Session session = HibernateUtil.currentSession();
//
//			return carregarCampo(session, entidade, id, campo, predicates);
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	public static void main(String[] a) {
//		Integer numeroCheque = 135;
//		Long codigoCooperativa = 1066L;
//		Date dataMovimento = new Date();
//		BigDecimal valor = BigDecimal.ONE;
//
//		log.error(gerarLogError("buscarHistoricoMovimentoDevolucao", codigoCooperativa, dataMovimento, numeroCheque));
//
//		log.error(gerarLogError("buscarHistoricoMovimentoComValor", codigoCooperativa, dataMovimento, numeroCheque,
//				valor));
//
//		log.error(gerarLogError("buscarSemParametro"));
//
//		log.error(gerarLogError("buscarPelaCooperativa", codigoCooperativa));
//	}
//
//}