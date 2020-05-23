package com.learn.orderfulfillment.restdataservices.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orderfulfillment.restdataservices.entity.ProductDetail;

@Repository
public interface ProductDetailDao extends JpaRepository<ProductDetail, BigInteger>{
	
	public List<ProductDetail> findAll();
	public ProductDetail findByProductId(String productId);
}
