package br.com.dxc.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.dxc.core.lock.MetodoLock;
import br.com.dxc.exception.ApplicationBusinessExceptionCode;
import br.com.dxc.exception.ApplicationValidatorException;
import br.com.dxc.util.HibernateUtil;

public abstract class AbstractHibernateDAO<T> {

	private static Logger logger = LoggerFactory.getLogger(AbstractHibernateDAO.class);

	public static final String PREFIXO_LOG = "CRESOL_ERROR_MENSAGEM_DEFAULT";

	public static final String SEM_PARAMETROS = "SEM PARAMETROS";

	private Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public void create(T entity) {
		getCurrentSession().persist(entity);
	}

	public void update(T entity) {
		getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	/**
	 * @see br.com.cresol.colmeia.dao.IGenericaDAO#tryAcquireLock(br.com.cresol.colmeia.dao.GenericaHibernateDAO.MetodoLock,
	 *      java.lang.Integer)
	 */
	public Boolean tryAcquireLock(MetodoLock metodoLock, Integer chave) throws ApplicationValidatorException {
		return this.tryAcquireLock(metodoLock, chave, null);
	}

	/**
	 * @see br.com.cresol.colmeia.dao.IGenericaDAO#tryAcquireLock(java.lang.Long)
	 */
	public Boolean tryAcquireLock(Long chave) throws ApplicationValidatorException {
		return this.tryAcquireLock(null, null, chave);
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	private Boolean tryAcquireLock(MetodoLock metodoLock, Integer chave, Long chaveLonga)
			throws ApplicationValidatorException {

		try {
			Session session = sessionFactory.getCurrentSession();

			StringBuffer sql = new StringBuffer();
			sql.append("select pg_try_advisory_xact_lock(");
			if (chaveLonga == null) {
				sql.append(":metodo, :chave");
			} else {
				sql.append(":chaveLonga");
			}
			sql.append("); ");

			SQLQuery q = session.createSQLQuery(sql.toString());

			if (chaveLonga == null) {
				q.setInteger("metodo", metodoLock.getCodigo());
				q.setInteger("chave", chave);
			} else {
				q.setLong("chaveLonga", chaveLonga);
			}

			Boolean acquire = (Boolean) q.uniqueResult();
			return acquire != null ? acquire : Boolean.FALSE;
		} catch (Exception e) {
			logger.error(gerarLogError("tryAcquireLock", metodoLock, chave, chaveLonga), e);
			throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_TRY_ACQUIRE_LOCK, e);
		} finally {
			sessionFactory.close();
		}
	}

	/**
	 * @see br.com.cresol.colmeia.dao.IGenericaDAO#acquireLock(br.com.cresol.colmeia.dao.GenericaHibernateDAO.MetodoLock,
	 *      java.lang.Integer)
	 */
	public void acquireLock(MetodoLock metodoLock, Integer chave) throws ApplicationValidatorException {
		this.acquireLock(metodoLock, chave, null);
	}

	/**
	 * @see br.com.cresol.colmeia.dao.IGenericaDAO#acquireLock(java.lang.Long)
	 */
	public void acquireLock(Long chave) throws ApplicationValidatorException {
		this.acquireLock(null, null, chave);
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	private void acquireLock(MetodoLock metodoLock, Integer chave, Long chaveLonga)
			throws ApplicationValidatorException {

		try {
			Session session = sessionFactory.getCurrentSession(); // TODO é isso mesmo?

			StringBuffer sql = new StringBuffer();
			sql.append("select cast(pg_advisory_xact_lock(");
			if (chaveLonga == null) {
				sql.append(":metodo, :chave");
			} else {
				sql.append(":chaveLonga");
			}
			sql.append(") as text); ");

			SQLQuery q = session.createSQLQuery(sql.toString());

			if (chaveLonga == null) {
				q.setInteger("metodo", metodoLock.getCodigo());
				q.setInteger("chave", chave);
			} else {
				q.setLong("chaveLonga", chaveLonga);
			}

			q.uniqueResult();
		} catch (Exception e) {
			logger.error(gerarLogError("acquireLock", metodoLock, chave, chaveLonga), e);
			throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_ACQUIRE_LOCK, e);
		} finally {
			sessionFactory.close();
		}
	}

	public static String gerarLogError(String nomeMetodo, Object... parametros) {

		StringBuilder log = new StringBuilder(PREFIXO_LOG);
		log.append(": ");
		log.append(nomeMetodo);
		log.append("(");

		if (parametros != null && parametros.length > 0) {

			for (int i = 0; i < parametros.length; i++) {

				if ((parametros.length - 1) != i) {
					log.append(parametros[i]);
					log.append(", ");
				} else {
					log.append(parametros[i]);
				}
			}
		} else {
			log.append(SEM_PARAMETROS);
		}

		log.append(")");

		return log.toString();
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}