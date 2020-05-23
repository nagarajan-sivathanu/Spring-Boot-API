package com.learn.orderfulfillment.restdataservices.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orderfulfillment.restdataservices.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,BigInteger> {
	public List<Product> findAll();
	public Product findByProductId(BigInteger productId);
}
