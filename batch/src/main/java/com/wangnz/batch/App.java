package com.wangnz.batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class App implements CommandLineRunner {
//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    Job job;
//
    @Override
    public void run(String... args) throws Exception {
//        JobParameters params = new JobParametersBuilder()
//                .addString("JobID", String.valueOf(System.currentTimeMillis()))
//                .toJobParameters();
//        jobLauncher.run(job, params);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
