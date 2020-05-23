package com.learn.orderfulfillment.restdataservices.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orderfulfillment.restdataservices.entity.UserPreference;
import com.learn.orderfulfillment.restdataservices.entity.UserPreferenceKey;

@Repository
public interface UserPreferenceDao extends JpaRepository<UserPreference, UserPreferenceKey> {
	public List<UserPreference> findAll();
	void deleteByUserIdAndProductId(BigInteger userId, BigInteger productId);
}
