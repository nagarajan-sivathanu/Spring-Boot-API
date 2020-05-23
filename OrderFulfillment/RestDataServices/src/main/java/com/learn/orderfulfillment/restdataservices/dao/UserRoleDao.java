package com.learn.orderfulfillment.restdataservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orderfulfillment.restdataservices.entity.UserRole;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole, String>{
	public UserRole findByUserRoleCode(String userRoleCode);	
}
