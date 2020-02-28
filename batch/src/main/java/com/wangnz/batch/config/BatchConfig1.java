package com.wangnz.batch.config;

import com.wangnz.batch.task.TaskOne;
import com.wangnz.batch.task.TaskTwo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
//@EnableBatchProcessing
public class BatchConfig1 {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step stepOne() {
        return steps.get("stepOne")
                .tasklet(new TaskOne())
                .build();
    }

    @Bean
    public Step stepTwo() {
        return steps.get("stepTwo")
                .tasklet(new TaskTwo())
                .build();
    }

    @Bean
    public Job demoJob() {
        return jobs.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .start(stepOne())
                .next(stepTwo())
                .build();
    }
}
