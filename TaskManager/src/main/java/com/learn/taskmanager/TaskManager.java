package com.learn.taskmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManager {
	private static final  Logger log = LoggerFactory.getLogger(TaskManager.class);
	public static void main(String[] args) {
		SpringApplication.run(TaskManager.class, args);
		log.info("Spring Boot App has been executed Successfully");
	}
}
