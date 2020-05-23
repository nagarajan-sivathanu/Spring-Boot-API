package com.learn.orderfulfillment.restdataservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orderfulfillment.restdataservices.entity.Status;

@Repository
public interface StatusDao extends JpaRepository<Status,String> {
	public Status findByStatusCategoryAndStatusCode(
			String statusCategory,String statusCode);
}
