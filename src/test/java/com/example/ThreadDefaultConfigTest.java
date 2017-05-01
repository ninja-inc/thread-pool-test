package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ThreadDefaultConfigApp.class)
public class ThreadDefaultConfigTest {
	@Autowired
	private HeavyTaskService test;
	
	@Test
	public void test01() {
		log.info("test start");
		for (int i=0; i<3; i++) {
			test.execute();
		}
		log.info("test end");
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
	}
}