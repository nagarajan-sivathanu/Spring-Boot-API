package com.learn.HelloWorldDocker.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
@CrossOrigin
public class HelloWorldDockerController {
	private Logger logger = LoggerFactory.getLogger(HelloWorldDockerController.class);
	
	@GetMapping("greetings")
	public String getGreeting() {
		logger.debug("Inside HelloWorldDockerController --> getGreeting() Method");
		return "Welcome to Docker World!!!!!";
	}
	
}
