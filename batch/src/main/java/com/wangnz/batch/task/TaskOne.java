package com.wangnz.batch.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.lang.Nullable;

public class TaskOne implements Tasklet {
    @Nullable
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("TaskOne start");
        System.out.println("TaskOne done");
        return RepeatStatus.FINISHED;
    }
}
