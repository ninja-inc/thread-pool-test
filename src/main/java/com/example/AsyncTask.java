package com.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AsyncTask {
	@Async
	public void execute() {
		log.info("@Async start");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		
		log.info("@Async end");
	}
}
