package br.com.dxc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dxc.domain.BatchJobExecution;
import br.com.dxc.exception.ApplicationBusinessExceptionCode;
import br.com.dxc.exception.BusinessValidatorException;

@Service
public class JobService  {
	
	@Autowired
    private JobLauncher jobLauncher;
	
	@Autowired
    private JobOperator jobOperator;
	
	@PersistenceContext
    protected EntityManager em;

	public BatchJobExecution run(Job job, JobParametersBuilder builder) {
        try {
            try {
                JobExecution execution = this.jobLauncher.run(job, builder.toJobParameters());
                return this.em.find(BatchJobExecution.class, execution.getId());
            } catch (JobExecutionAlreadyRunningException e) {
                throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_ESTA_EXECUTANDO, e, new Object[0]);
            } catch (JobRestartException e2) {
                throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_JA_EXISTE_NAO_RESTARAVEL, e2, new Object[0]);
            } catch (JobInstanceAlreadyCompleteException e3) {
                throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_COB_ERROR_JOB_CONCLUIDO, e3, new Object[0]);
            } catch (JobParametersInvalidException e4) {
                throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_PARAMETRO_INVALIDO, e4, new Object[0]);
            }
        } catch (Exception e) {
            throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_RUN, e, new Object[0]);
        }
    }

	public void stop(Long executionId) {
		try {
			try {
				this.jobOperator.stop(executionId);
			} catch (NoSuchJobExecutionException e) {
				throw new BusinessValidatorException(
						ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_NAO_ENCONTRADO, e, new Object[0]);
			} catch (JobExecutionNotRunningException e2) {
				throw new BusinessValidatorException(
						ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_NAO_INTERROMPIDO, e2, new Object[0]);
			}
		} catch (Exception e) {
			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_STOP, e,
					new Object[0]);
		}
	}

	public void abandon(Long executionId) {
		try {
			try {
				this.jobOperator.abandon(executionId);
			} catch (NoSuchJobExecutionException e) {
				throw new BusinessValidatorException(
						ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_NAO_ENCONTRADO, e, new Object[0]);
			} catch (JobExecutionAlreadyRunningException e2) {
				throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_NAO_ABORTADO,
						e2, new Object[0]);
			}
		} catch (Exception e) {
			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_ABANDON, e,
					new Object[0]);
		}
	}

	public BatchJobExecution restart(Long executionId) {
		try {
			try {
				long execution = this.jobOperator.restart(executionId);
				return this.em.find(BatchJobExecution.class, execution);
			} catch (JobInstanceAlreadyCompleteException e) {
				throw new BusinessValidatorException(
						ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_ESTA_EXECUTANDO, e, new Object[0]);
			} catch (NoSuchJobExecutionException e2) {
				throw new BusinessValidatorException(
						ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_NAO_ENCONTRADO, e2, new Object[0]);
			} catch (NoSuchJobException e3) {
				throw new BusinessValidatorException(
						ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_NAO_ENCONTRADO, e3, new Object[0]);
			} catch (JobRestartException e4) {
				throw new BusinessValidatorException(
						ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_NAO_RESTARTAVEL, e4, new Object[0]);
			} catch (JobParametersInvalidException e5) {
				throw new BusinessValidatorException(
						ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_PARAMETRO_INVALIDO, e5, new Object[0]);
			}
		} catch (Exception e) {
			throw new BusinessValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_JOB_RESTART, e,
					new Object[0]);
		}
	}

}
