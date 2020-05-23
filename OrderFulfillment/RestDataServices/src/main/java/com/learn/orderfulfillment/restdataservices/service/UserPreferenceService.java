package com.learn.orderfulfillment.restdataservices.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.orderfulfillment.restdataservices.dao.UserPreferenceDao;
import com.learn.orderfulfillment.restdataservices.entity.UserPreference;

@Service
@Transactional
public class UserPreferenceService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired private UserPreferenceDao userPreferenceDao;
	
	public List<UserPreference> getAllUserPreferences(){
		log.info("Inside UserPreferenceService --> getAllUserPreferences Method");
		return userPreferenceDao.findAll()
			.stream().map(i-> {
				i.setStatusCode(i.getProduct().getProductDetail()
						.getStatusCode());
				return i;
			}).collect(Collectors.toList());
	}
	
	public void addUserPreference(UserPreference userPreference) {
		log.info("Inside UserPreferenceService --> addUserPreference Method"); 
		userPreference.setUpdatedTimeStamp(LocalDateTime.now());
		userPreferenceDao.save(userPreference);
	}
	
	public void deleteUserPreference(UserPreference userPreference) {
		log.info("Inside UserPreferenceService --> deleteUserPreference Method");
		userPreferenceDao.deleteByUserIdAndProductId(userPreference.getUserId(),
				userPreference.getProductId());
	}
}
