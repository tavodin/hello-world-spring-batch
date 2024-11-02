package com.tavodin.HelloWorldSpringBatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BathConfig {

    @Bean
    public Job job(JobRepository jobRepository, Step printHelloStep) {
        return new JobBuilder("job", jobRepository)
                .start(printHelloStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
