package br.com.dxc.core.lock;

import java.io.Serializable;

import br.com.dxc.core.dao.GenericHibernateDAO;
import br.com.dxc.exception.ApplicationValidatorException;

public class AdvisoryLockMethod extends AdvisoryLockStrategy {

	@Override
	public boolean tryAcquireLock() throws ApplicationValidatorException {
		GenericHibernateDAO<Object, Serializable> hibernateDAO = new GenericHibernateDAO<Object, Serializable>() {
		};
		return hibernateDAO.tryAcquireLock(this.getMetodoLock(), this.getChaveInt());
	}

	@Override
	public void acquireLock() throws ApplicationValidatorException {
		GenericHibernateDAO<Object, Serializable> hibernateDAO = new GenericHibernateDAO<Object, Serializable>() {
		};
		hibernateDAO.acquireLock(this.getMetodoLock(), this.getChaveInt());
	}
}
