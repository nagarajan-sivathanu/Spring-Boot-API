package com.learn.orderfulfillment.restdataservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.orderfulfillment.restdataservices.entity.UserPreference;
import com.learn.orderfulfillment.restdataservices.service.UserPreferenceService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserPreferenceController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	List<UserPreference> userPreferences;
	@Autowired	private UserPreferenceService userPreferenceService;
	
	@GetMapping(value = "/user-preference")
	public ResponseEntity<List<UserPreference>> getAllUserPreferences() {
		log.info("Inside UserPreferenceController --> getAllUserPreferences Method");
		userPreferences = userPreferenceService.getAllUserPreferences();
		return new ResponseEntity<>(userPreferences, HttpStatus.OK);
	}
	
	@PostMapping(value="/user-preference")
	public ResponseEntity<UserPreference>  addUserPreference(
			@RequestBody UserPreference userPreference) {
		log.info("Inside UserPreferenceController --> addUserPreference Method");
		userPreferenceService.addUserPreference(userPreference);	
		return new ResponseEntity<>(userPreference, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/user-preference")
	public ResponseEntity<UserPreference> deleteUserPreference(
			@RequestBody UserPreference userPreference) {
		log.info("Inside UserPreferenceController --> deleteUserPreference Method");
		userPreferenceService.deleteUserPreference(userPreference);
		return new ResponseEntity<>(userPreference, HttpStatus.OK);
	}

}
