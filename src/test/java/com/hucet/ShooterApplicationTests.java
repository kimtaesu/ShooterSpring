package com.hucet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ShooterApplication.class)
public class ShooterApplicationTests {


	@Autowired
	JobLauncher mJobLauncher;

	@Test
	public void contextLoads() {
	}

}
