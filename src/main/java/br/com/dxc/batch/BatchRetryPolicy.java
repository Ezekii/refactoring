package br.com.dxc.batch;

import javax.persistence.PersistenceException;

import org.hibernate.JDBCException;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.NeverRetryPolicy;

public class BatchRetryPolicy extends NeverRetryPolicy {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void registerThrowable(RetryContext context, Throwable throwable) {
        if (throwable instanceof PersistenceException && throwable.getCause() instanceof JDBCException) {
            throw new RuntimeException(((JDBCException) throwable.getCause()).getSQLException());
        }
        throw new RuntimeException(throwable);
    }
}
