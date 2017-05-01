package com.example;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@SpringBootApplication
public class ThreadCustomConfigApp {

	public static void main(String[] args) {
		SpringApplication.run(ThreadPoolTestApplication.class, args);
	}
	
	// This executor instance will be used by both @Aync & TaskExecutor if AsyncConfigurerSupport works
	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.initialize();
		return executor;
	}
}

//@Configuration
//@EnableAsync
class AsyncConfigurer extends AsyncConfigurerSupport {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public Executor getAsyncExecutor() {
        return threadPoolTaskExecutor;
    }
}