package com.learn.mongoDB.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.mongoDB.pojo.UserInfo;
import com.learn.mongoDB.repository.UserInfoRepository;

@Service
public class UserInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public List<UserInfo> getAllUsers(){
		log.info("Inside UserInfoService --> getAllUsers Method");
		List<UserInfo> userInfoList = new ArrayList<>();
		userInfoRepository.findAll().forEach(userInfoList::add);
		return userInfoList;	
	}
	
	public List<UserInfo> getUsersByLastName(final String lastName){
		log.info("Inside UserInfoService --> getUsersByLastName Method");
		List<UserInfo> userInfoList = new ArrayList<>();
		userInfoRepository.findByLastName(lastName).forEach(userInfoList::add);
		return userInfoList;	
	}
	
	public List<UserInfo> getUsersByAgeFilter(final Integer greaterThan,final Integer greaterThanEqualTo,
			final Integer lessThan,final Integer lessThanEqualTo,final Integer equalTo, final Integer notEqualTo){
		log.info("Inside UserInfoService --> getUsersByAgeFilter Method");
		List<UserInfo> userInfoList = new ArrayList<>();
		if(greaterThan != null && lessThan != null)
		{
			log.info("Invoking findByAgeBetween Method -> GreaterThan : {}, LessThan : {}",greaterThan,lessThan);
			userInfoRepository.findByAgeBetween(greaterThan,lessThan).forEach(userInfoList::add);
		}else if (greaterThan != null) {
			log.info("Invoking findByAgeGreaterThan Method -> GreaterThan : {}",greaterThan);
			userInfoRepository.findByAgeGreaterThan(greaterThan).forEach(userInfoList::add);
		}else if (greaterThanEqualTo != null) {
			log.info("Invoking findByAgeGreaterThanEqualTo Method -> GreaterThanEqualTo : {}",greaterThanEqualTo);
			userInfoRepository.findByAgeGreaterThanEqualTo(greaterThanEqualTo).forEach(userInfoList::add);
		}else if (lessThan != null) {
			log.info("Invoking findByAgeLessThan Method -> LessThan : {}",lessThan);
			userInfoRepository.findByAgeLessThan(lessThan).forEach(userInfoList::add);
		}else if (lessThanEqualTo != null) {
			log.info("Invoking findByAgeLesserThanEqualTo Method -> LessThanEqualTo : {}",lessThanEqualTo);
			userInfoRepository.findByAgeLesserThanEqualTo(lessThanEqualTo).forEach(userInfoList::add);
		}else if (equalTo != null) {
			log.info("Invoking findByAgeEqualTo Method -> EqualTo : {}",equalTo);
			userInfoRepository.findByAgeEqualTo(equalTo).forEach(userInfoList::add);
		}else if (notEqualTo != null) {
			log.info("Invoking findByAgeNotEqualTo Method -> NotEqualTo : {}",notEqualTo);
			userInfoRepository.findByAgeNotEqualTo(notEqualTo).forEach(userInfoList::add);
		}
		return userInfoList;	
	}
}
