package com.example;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class HeavyTaskService {
	private final TaskExecutor executor;
	private final AsyncTask asyncTask;
	
	public void execute() {
		log.info("HeavyTaskService start");
		
		asyncTask.execute();
		
		executor.execute(() -> {
			log.info("TaskExecutor start");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				log.error(e.getMessage(), e);
			}
			log.info("TaskExecutor end");
		});
		
		log.info("HeavyTaskService end");
	}
}
