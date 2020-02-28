package com.wangnz.batch.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.lang.Nullable;

public class TaskTwo implements Tasklet {
    @Nullable
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("TaskTwo start");
        System.out.println("TaskTwo done");
        return RepeatStatus.FINISHED;
    }
}
