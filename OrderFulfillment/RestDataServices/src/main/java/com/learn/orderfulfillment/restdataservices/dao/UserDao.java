package com.learn.orderfulfillment.restdataservices.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orderfulfillment.restdataservices.entity.User;


@Repository
public interface UserDao extends JpaRepository<User, BigInteger>{
	public List<User> findAll();
}
