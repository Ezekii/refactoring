package br.com.dxc.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

@Service
public class TesteTasklet {

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		return RepeatStatus.FINISHED;
	}
}
