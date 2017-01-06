package com.hucet.quartz.launcher;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class QuartzLauncher {
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    void launcher(JobDetail jobDetail, CronTrigger cronTrigger) throws SchedulerException {
        schedulerFactoryBean.getScheduler().getJobGroupNames();

        TriggerKey key = new TriggerKey("trigger1", "group1");
        schedulerFactoryBean.getScheduler().checkExists(key);
        schedulerFactoryBean.getScheduler().scheduleJob(jobDetail, cronTrigger);
    }
}
