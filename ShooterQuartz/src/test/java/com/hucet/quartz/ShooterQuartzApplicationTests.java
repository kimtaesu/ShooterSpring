package com.hucet.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ShooterQuartzApplication.class)
public class ShooterQuartzApplicationTests {

    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    @Test
    public void contextLoads() {

    }

}
