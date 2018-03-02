package br.com.dxc.batch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.batch.core.listener.ItemListenerSupport;
import org.springframework.batch.core.scope.context.StepSynchronizationManager;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.transaction.annotation.Transactional;

import br.com.dxc.domain.BatchStepSkip;

public class CargaJobListener extends ItemListenerSupport<AbstractItem, Object> {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void onReadError(Exception ex) {
        BatchStepSkip skip = new BatchStepSkip();
        skip.setStepExecutionId(StepSynchronizationManager.getContext().getStepExecution().getId());
        skip.setType(BatchStepSkip.BatchStepSkipTypeEnum.READ);
        if (ex instanceof FlatFileParseException) {
            skip.setLineNumber(((FlatFileParseException) ex).getLineNumber());
            skip.setLine(((FlatFileParseException) ex).getInput());
            skip.setMessage((ex.getCause() != null) ? ex.getCause().getMessage() : ex.getMessage());
        } else {
            skip.setMessage(ex.getMessage());
        }
        this.em.persist(skip);
        super.onReadError(ex);
    }

    @Transactional
    public void onProcessError(AbstractItem item, Exception e) {
        BatchStepSkip skip = new BatchStepSkip();
        skip.setStepExecutionId(StepSynchronizationManager.getContext().getStepExecution().getId());
        skip.setType(BatchStepSkip.BatchStepSkipTypeEnum.PROCESS);
        skip.setLineNumber(item.lineNumber);
        skip.setLine(item.line);
        skip.setMessage(e.getMessage());
        this.em.persist(skip);
        super.onProcessError(item, e);
    }

    public void onWriteError(Exception e, List<?> item) {
        BatchStepSkip skip = new BatchStepSkip();
        skip.setStepExecutionId(StepSynchronizationManager.getContext().getStepExecution().getId());
        skip.setType(BatchStepSkip.BatchStepSkipTypeEnum.WRITE);
        skip.setMessage(e.getMessage());
        this.em.persist(skip);
        super.onWriteError(e, item);
    }
}
