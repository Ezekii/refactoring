package br.com.dxc.core.lock;

import java.io.Serializable;

import br.com.cresol.colmeia.core.exception.ApplicationException;
import br.com.cresol.colmeia.dao.GenericaHibernateDAO;

public class AdvisoryLockMethod extends AdvisoryLockStrategy {

	@Override
	public boolean tryAcquireLock() throws ApplicationException {
		GenericaHibernateDAO<Object, Serializable> hibernateDAO = new GenericaHibernateDAO<Object, Serializable>() {
		};
		return hibernateDAO.tryAcquireLock(this.getMetodoLock(),
				this.getChaveInt());
	}

	@Override
	public void acquireLock() throws ApplicationException {
		GenericaHibernateDAO<Object, Serializable> hibernateDAO = new GenericaHibernateDAO<Object, Serializable>() {
		};
		hibernateDAO.acquireLock(this.getMetodoLock(), this.getChaveInt());
	}
}
