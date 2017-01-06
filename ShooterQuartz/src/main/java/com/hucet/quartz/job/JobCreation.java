package com.hucet.quartz.job;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
public class JobCreation {
    @Bean
    JobDetail getJobDetail() {
        return newJob(SampleJob.class)
                .withIdentity("job1", "group1")
                .build();
    }

    @Bean
    CronTrigger getCronTrigger() {
        return newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/10 * * * * ?"))
                .build();
    }

}
