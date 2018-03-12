package br.com.dxc.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;
@Service
public class GlobalTasklet implements Tasklet {

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        contribution.incrementReadCount();
        contribution.incrementWriteCount(1);
        return RepeatStatus.FINISHED;
    }
}
