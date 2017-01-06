package com.hucet.batch.config;

import com.hucet.batch.io.CodeItemReader;
import com.hucet.batch.io.CodeItemWriter;
import com.hucet.batch.io.CodeProcessor;
import com.hucet.batch.listeners.LogProcessListener;
import com.hucet.batch.listeners.ProtocolListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by taesu- on 2016-06-25.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job addNewPodcastJob() {
        return jobs.get("addNewPodcastJob")
                .listener(protocolListener())
                .start(step())
                .build();
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<String, String>chunk(1) //important to be one in this case to commit after every line read
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .listener(logProcessListener())
                .build();
    }

    @Bean
    public CodeItemWriter itemWriter() {
        CodeItemWriter writer = new CodeItemWriter();
        return writer;
    }

    @Bean
    public CodeItemReader itemReader() {
        CodeItemReader reader = new CodeItemReader();
        return reader;
    }

    @Bean
    public CodeProcessor itemProcessor() {
        CodeProcessor processor = new CodeProcessor();
        return processor;
    }

    @Bean
    public ProtocolListener protocolListener() {
        return new ProtocolListener();
    }

    @Bean
    public LogProcessListener logProcessListener() {
        return new LogProcessListener();
    }
}
