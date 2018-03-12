package br.com.dxc.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class GlobalListener implements JobExecutionListener {

    public void beforeJob(JobExecution jobExecution) {
    }

    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
        	
        }
    }

}
