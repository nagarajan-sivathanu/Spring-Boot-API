package com.learn.orderfulfillment.restdataservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.orderfulfillment.restdataservices.entity.User;
import com.learn.orderfulfillment.restdataservices.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	List<User> users;
	@Autowired	private UserService userService;
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers() {
		log.info("Inside UserController --> getAllUsers Method");
		users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PostMapping(value="/users")
	public ResponseEntity<User>  createTask(@RequestBody User user) {
		log.info("Inside UserController --> createUser Method");
		userService.createUser(user);	
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/users")
	public ResponseEntity<User> updateTask(@RequestBody User user) {
		log.info("Inside UserController --> updateUser Method");
		userService.updateUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
