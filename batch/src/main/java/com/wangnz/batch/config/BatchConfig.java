package com.wangnz.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
//@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public ItemReader<String> reader() throws Exception {
        ItemReader<String> itemReader = new ItemReader<String>() {
            @Override
            public String read() throws Exception {
                System.out.println("reader");
                return "123";
            }
        };
        return itemReader;
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        ItemProcessor<String, String> processor = new ItemProcessor<String, String>() {
            @Override
            public String process(String person) throws Exception {
                System.out.println("processor");
                return "456";
            }
        };
        return processor;
    }

    @Bean
    public ItemWriter<String> writer() {
        ItemWriter<String> itemWriter = new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> list) throws Exception {
                System.out.println("writer");
            }
        };
        return itemWriter;
    }

//    @Bean
//    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
//        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
//        jobRepositoryFactoryBean.setDataSource(dataSource);
//        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
//        jobRepositoryFactoryBean.setDatabaseType(DatabaseType.H2.name());
//
//        return jobRepositoryFactoryBean.getObject();
//    }

//    @Bean
//    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
//        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
//        jobLauncher.setJobRepository(this.jobRepository(dataSource, transactionManager));
//
//        return jobLauncher;
//    }

    @Bean
    public Job myJob(JobBuilderFactory jobs, Step step) {
        return jobs.get("myJob1")
                .incrementer(new RunIdIncrementer())
                .flow(step) // 为Job指定Step
                .end()
//                .listener(myJobListener()) // 绑定监听器
                .build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<String> reader, ItemWriter<String> writer, ItemProcessor<String, String> processor) {
        return stepBuilderFactory.get("MyStep")
                .<String, String>chunk(5) // 批处理每次提交5000条数据
                .reader(reader) // 给step绑定reader
                .processor(processor) // 给step绑定processor
                .writer(writer) // 给step绑定writer
                .build();
    }

//    @Bean
//    public MyJobListener myJobListener() {
//        return new MyJobListener();
//    }

}
