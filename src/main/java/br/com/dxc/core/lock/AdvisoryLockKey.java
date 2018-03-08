//package br.com.dxc.core.lock;
//
//import java.io.Serializable;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.apache.poi.ss.formula.functions.T;
//
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.cresol.colmeia.dao.GenericaHibernateDAO;
//import br.com.dxc.exception.ApplicationValidatorException;
//import br.com.dxc.repository.BaseRepositoryImpl;
//
//public class AdvisoryLockKey extends AdvisoryLockStrategy {
//
//	@PersistenceContext
//	EntityManager entityManager;
//
//	@Override
//	public boolean tryAcquireLock() throws ApplicationValidatorException {
//		BaseRepositoryImpl<T, Serializable> baseRepo = new BaseRepositoryImpl<T, Serializable>((Class<T>) new Object(),
//				entityManager);
//		return baseRepo.tryAcquireLock(this.getChaveLong());
//	}
//
//	public void acquireLock() throws ApplicationValidatorException {
//		BaseRepositoryImpl<T, Serializable> baseRepo = new BaseRepositoryImpl<T, Serializable>((Class<T>) new Object(),
//				entityManager);
//		return baseRepo.acquireLock(this.getChaveLong());
//	}
//
//}
