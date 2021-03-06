package com.learn.mongoDB.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.mongoDB.pojo.FemaleCount;
import com.learn.mongoDB.pojo.StateCount;
import com.learn.mongoDB.pojo.UserInfo;
import com.learn.mongoDB.service.UserInfoService;

@RestController
@RequestMapping("/users")
public class UserInfoController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	List<UserInfo> userInfoList;
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("")
	public ResponseEntity<List<UserInfo>> getAllUsers() {
		log.info("Inside UserInfoController --> getAllUsers Method");
		userInfoList = userInfoService.getAllUsers();
		return new ResponseEntity<>(userInfoList, HttpStatus.OK);
	}
	
	@GetMapping("filter-by-last-name")
	public ResponseEntity<List<UserInfo>> getUsersByLastName(@RequestParam String lastName) {
		log.info("Inside UserInfoController --> getUsersByLastName Method");
		userInfoList = userInfoService.getUsersByLastName(lastName);
		return new ResponseEntity<>(userInfoList, HttpStatus.OK);
	}
	
	@GetMapping("filter-by-age")
	public ResponseEntity<List<UserInfo>> getUsersByAgeFilter(
			@RequestParam(value = "greaterThan", required = false) Integer greaterThan,
			@RequestParam(value = "greaterThanEqualTo", required = false) Integer greaterThanEqualTo,
			@RequestParam(value = "lessThan", required = false) Integer lessThan,
			@RequestParam(value = "lessThanEqualTo", required = false) Integer lessThanEqualTo,
			@RequestParam(value = "equalTo", required = false) Integer equalTo,
			@RequestParam(value = "notEqualTo", required = false) Integer notEqualTo) {
		log.info("Inside UserInfoController --> getUsersByAgeFilter Method");
		userInfoList = userInfoService.getUsersByAgeFilter(greaterThan,greaterThanEqualTo,lessThan,lessThanEqualTo,equalTo,notEqualTo);
		return new ResponseEntity<>(userInfoList, HttpStatus.OK);
	}
	
	@GetMapping("filter-by-gender-and_location")
	public ResponseEntity<List<UserInfo>> getUsersByGenderAndLocationFilter(
			@RequestParam(value = "gender", required = true) String gender,
			@RequestParam(value = "location", required = true) String location) {
		log.info("Inside UserInfoController --> getUsersByGenderAndLocationFilter Method");
		userInfoList = userInfoService.getUsersByGenderAndLocationFilter(gender,location);
		return new ResponseEntity<>(userInfoList, HttpStatus.OK);
		
	}
	
	@GetMapping("filter-by-firstname-or_lastname")
	public ResponseEntity<List<UserInfo>> getUsersByFirstOrLastnameFilter(
			@RequestParam(value = "first", required = false) String firstName,
			@RequestParam(value = "last", required = false) String lastName) {
		log.info("Inside UserInfoController --> getUsersByFirstOrLastnameFilter Method");
		userInfoList = userInfoService.getUsersByFirstOrLastNameFilter(firstName, lastName);
		return new ResponseEntity<>(userInfoList, HttpStatus.OK);
		
	}
	
	@GetMapping("location-wise-female-count")
	public ResponseEntity<List<FemaleCount>> getStateWiseFemaleCount(){
		log.info("Inside UserInfoController --> getStateWiseFemaleCount Method");
		return new ResponseEntity<>(userInfoService.getStateWiseFemaleCount(),HttpStatus.OK);
	}
	
	@GetMapping("location-wise-population")
	public ResponseEntity<List<StateCount>> getStateWisePopulationCount(){
		log.info("Inside UserInfoController --> getStateWisePopulationCount Method");
		return new ResponseEntity<>(userInfoService.getStateWisePopulationCount(),HttpStatus.OK);
	}
	
}
