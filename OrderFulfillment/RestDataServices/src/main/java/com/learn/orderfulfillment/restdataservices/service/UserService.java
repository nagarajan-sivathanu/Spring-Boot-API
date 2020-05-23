package com.learn.orderfulfillment.restdataservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.orderfulfillment.restdataservices.dao.UserDao;
import com.learn.orderfulfillment.restdataservices.entity.User;

@Service
public class UserService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired private UserDao userDao;
	
	public List<User> getAllUsers(){
		log.info("Inside UserService --> getAllUsers Method");
		List<User> users = new ArrayList<>();
		userDao.findAll().forEach(users::add);
		return users;	
	}
	
	public void createUser(User user) {
		log.info("Inside UserService --> createUser Method"); 
		user.setUpdatedTimeStamp(LocalDateTime.now());
		userDao.save(user);
	}
	
	public void updateUser(User user) {
		log.info("Inside UserService --> updateUser Method");
		user.setUpdatedTimeStamp(LocalDateTime.now());
		userDao.save(user);
	}
}
