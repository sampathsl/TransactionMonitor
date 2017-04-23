package com.n26.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by SAMPATH on 4/22/2017.
 */

@SpringBootApplication
@EnableAsync
public class MainTransactionMonitor extends AsyncConfigurerSupport {

	/**
	 * Starting point of the RESTful service
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainTransactionMonitor.class, args);
	}

	@Value("${batch.core.pool.size}")
	private int corePollSize;

	@Value("${batch.max.pool.size}")
	private int maxPoolSize;

	@Value("${batch.queue.capacity}")
	private int queueCapacity;

	@Override
	@Bean(name = "transactionExecutor")
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePollSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();
		return executor;
	}

}
