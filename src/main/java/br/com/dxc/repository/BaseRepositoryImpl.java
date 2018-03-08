//package br.com.dxc.repository;
//
//import java.io.Serializable;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//
//import br.com.dxc.exception.ApplicationValidatorException;
//
//public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
//		implements BaseRepository<T, ID> {
//
//	@PersistenceContext
//	private static EntityManager entityManager;
//
//	// @Autowired
//	// private static SessionFactory sessionFactory;
//
//	public BaseRepositoryImpl(Class<T> domainClass) {
//		super(domainClass, entityManager);
//	}
//
//	@Override
//	public <S extends T> Iterable<S> save(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public T findOne(ID id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean exists(ID id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Iterable<T> findAll(Iterable<ID> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void delete(ID id) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void delete(Iterable<? extends T> entities) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Boolean tryAcquireLock(Long chave) throws ApplicationValidatorException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	// @Override
//	// public Boolean tryAcquireLock(Long chave) throws
//	// ApplicationValidatorException {
//	// // TODO Auto-generated method stub
//	// return null;
//	// }
//	//
//	// @Override
//	// public Boolean tryAcquireLock(MetodoLock metodoLock, Integer chave) throws
//	// ApplicationValidatorException {
//	// // TODO Auto-generated method stub
//	// return null;
//	// }
//	//
//	// @Override
//	// public Boolean tryAcquireLock(MetodoLock metodoLock, Integer chave, Long
//	// chaveLonga)
//	// throws ApplicationValidatorException {
//	// // TODO Auto-generated method stub
//	// return null;
//	// }
//	//
//	// /**
//	// * @see
//	// br.com.cresol.colmeia.dao.IGenericaDAO#acquireLock(br.com.cresol.colmeia.dao.GenericaHibernateDAO.MetodoLock,
//	// * java.lang.Integer)
//	// */
//	// public void acquireLock(MetodoLock metodoLock, Integer chave) throws
//	// ApplicationValidatorException {
//	// this.acquireLock(metodoLock, chave, null);
//	// }
//	//
//	// /**
//	// * @see br.com.cresol.colmeia.dao.IGenericaDAO#acquireLock(java.lang.Long)
//	// */
//	// public void acquireLock(Long chave) throws ApplicationValidatorException {
//	// this.acquireLock(null, null, chave);
//	// }
//	//
//	// @Override
//	// public void acquireLock(MetodoLock metodoLock, Integer chave, Long
//	// chaveLonga) throws ApplicationValidatorException {
//	//
//	// try {
//	// Session session = entityManager.
//	//
//	// StringBuffer sql = new StringBuffer();
//	// sql.append("select cast(pg_advisory_xact_lock(");
//	// if (chaveLonga == null) {
//	// sql.append(":metodo, :chave");
//	// } else {
//	// sql.append(":chaveLonga");
//	// }
//	// sql.append(") as text); ");
//	//
//	// SQLQuery q = session.createSQLQuery(sql.toString());
//	//
//	// if (chaveLonga == null) {
//	// q.setInteger("metodo", metodoLock.getCodigo());
//	// q.setInteger("chave", chave);
//	// } else {
//	// q.setLong("chaveLonga", chaveLonga);
//	// }
//	//
//	// q.uniqueResult();
//	// } catch (Exception e) {
//	// log.error(gerarLogError("acquireLock", metodoLock, chave, chaveLonga), e);
//	// throw new ApplicationValidatorException(e);
//	// } finally {
//	// HibernateUtil.closeSession();
//	// }
//	// }
//
//}