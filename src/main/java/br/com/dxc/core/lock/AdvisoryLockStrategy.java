//package br.com.dxc.core.lock;
//
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.cresol.colmeia.dao.GenericaHibernateDAO.MetodoLock;
//
//public abstract class AdvisoryLockStrategy {
//
//	private MetodoLock metodoLock;
//	private Integer chaveInt;
//	private Long chaveLong;
//
//	public MetodoLock getMetodoLock() {
//		return metodoLock;
//	}
//
//	public void setMetodoLock(MetodoLock metodoLock) {
//		this.metodoLock = metodoLock;
//	}
//
//	public Integer getChaveInt() {
//		return chaveInt;
//	}
//
//	public void setChaveInt(Integer chaveInt) {
//		this.chaveInt = chaveInt;
//	}
//
//	public Long getChaveLong() {
//		return chaveLong;
//	}
//
//	public void setChaveLong(Long chaveLong) {
//		this.chaveLong = chaveLong;
//	}
//
//	public abstract boolean tryAcquireLock() throws ApplicationException;
//
//	public abstract void acquireLock() throws ApplicationException;
//
//}
