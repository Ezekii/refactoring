package br.com.dxc.core.lock;

import java.io.Serializable;

import br.com.cresol.colmeia.core.exception.ApplicationException;
import br.com.cresol.colmeia.dao.GenericaHibernateDAO;

public class AdvisoryLockKey extends AdvisoryLockStrategy {

	@Override
	public boolean tryAcquireLock() throws ApplicationException {
		GenericaHibernateDAO<Object, Serializable> hibernateDAO = new GenericaHibernateDAO<Object, Serializable>() {
		};
		return hibernateDAO.tryAcquireLock(this.getChaveLong());
	}

	public void acquireLock() throws ApplicationException {
		GenericaHibernateDAO<Object, Serializable> hibernateDAO = new GenericaHibernateDAO<Object, Serializable>() {
		};
		hibernateDAO.acquireLock(this.getChaveLong());
	}

}
