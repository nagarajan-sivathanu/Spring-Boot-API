package com.learn.mongoDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.mongoDB.pojo.UserInfo;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
	@Autowired
	MongoTemplate mongoTemplate=null;   
	
	List<UserInfo> findAll();
	
	@Query("{'name.last': ?0}")
	List<UserInfo> findByLastName(final String lastName);
	
	@Query(value = "{'dob.age': {$gt: ?0}}", fields = "{name: 1,dob: 1, gender: 1}")
	List<UserInfo> findByAgeGreaterThan(final int age);
	
	@Query(value = "{'dob.age': {$gte: ?0}}", fields = "{name: 1,dob: 1, gender: 1}")
	List<UserInfo> findByAgeGreaterThanEqualTo(final int age);
	
	@Query(value = "{'dob.age': {$lt: ?0}}", fields = "{name: 1,dob: 1, gender: 1}")
	List<UserInfo> findByAgeLessThan(final int age);
	
	@Query(value = "{'dob.age': {$lte: ?0}}", fields = "{name: 1,dob: 1, gender: 1}")
	List<UserInfo> findByAgeLesserThanEqualTo(final int age);
	
	@Query(value = "{'dob.age': {$eq: ?0}}", fields = "{name: 1,dob: 1, gender: 1}")
	List<UserInfo> findByAgeEqualTo(final int age);
	
	@Query(value = "{'dob.age': {$ne: ?0}}", fields = "{name: 1,dob: 1, gender: 1}")
	List<UserInfo> findByAgeNotEqualTo(final int age);
	
	@Query(value = "{'dob.age': {$and: [{$gt: ?0}, {$lt: ?1}]}", fields = "{name: 1,dob: 1, gender: 1}")
	List<UserInfo> findByAgeBetween(final int ageGT, final int ageLT);
	
	@Query("{ $and: [{'gender': ?0},{'location.state': ?1}] }")
	List<UserInfo> findByGenderAndLocation(final String gender, final String location);
	
	@Query("{ $or: [{'name.first': ?0},{'name.last': ?1} ] }")
	List<UserInfo> findByFirstOrLastName(final String firstName, final String lastName);
	
}
