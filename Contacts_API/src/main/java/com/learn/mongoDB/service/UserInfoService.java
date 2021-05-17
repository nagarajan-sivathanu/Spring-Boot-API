package com.learn.mongoDB.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.learn.mongoDB.pojo.FemaleCount;
import com.learn.mongoDB.pojo.UserInfo;
import com.learn.mongoDB.repository.UserInfoRepository;

@Service
public class UserInfoService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private MongoTemplate mongoTemplate=null;
	
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
	
	public List<UserInfo> getUsersByGenderAndLocationFilter(final String gender, final String location){
		log.info("Inside UserInfoService --> getUsersByGenderAndLocationFilter Method");
		List<UserInfo> userInfoList = new ArrayList<>();
		userInfoRepository.findByGenderAndLocation(gender,location).forEach(userInfoList::add);
		return userInfoList;	
	}
	
	public List<UserInfo> getUsersByFirstOrLastNameFilter(final String firstName, final String lastName){
		log.info("Inside UserInfoService --> getUsersByFirstOrLastNameFilter Method");
		List<UserInfo> userInfoList = new ArrayList<>();
		userInfoRepository.findByFirstOrLastName(firstName, lastName).forEach(userInfoList::add);
		return userInfoList;	
	}
	
	public List<FemaleCount> getStateWiseFemaleCount(){
		log.info("Inside UserInfoService --> getStateWiseFemaleCount Method");
		
		MatchOperation matchStage = Aggregation.match(new Criteria("gender").is("female"));
		GroupOperation groupStage = Aggregation.group("location.state").count().as("totalFemale");
		SortOperation sortStage = Aggregation.sort(Sort.by(Direction.DESC, "totalFemale"));

        Aggregation agg = Aggregation.newAggregation(
            matchStage,
            groupStage,
            sortStage           
        );

        //Convert the aggregation result into a List
        AggregationResults<FemaleCount> groupResults 
            = mongoTemplate.aggregate(agg, UserInfo.class, FemaleCount.class);
        return groupResults.getMappedResults();		
	}
	
}
