package com.learn.orderfulfillment.restdataservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.orderfulfillment.restdataservices.dao.ProductDao;
import com.learn.orderfulfillment.restdataservices.entity.Product;
import com.learn.orderfulfillment.restdataservices.entity.ProductDetail;

@Service
@Transactional
public class ProductService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired private ProductDao productDao;
	
	public List<Product> getAllProducts(){
		log.info("Inside ProductService --> getAllProducts Method");
		List<Product> products = new ArrayList<>();
		productDao.findAll().forEach(products::add);
		return products;	
	}
	
	public void createProduct(Product product) {
		log.info("Inside ProductService --> createProduct Method"); 
		product.setUpdatedTimeStamp(LocalDateTime.now());
		product.getProductDetail().setUpdatedTimeStamp(LocalDateTime.now());
		product.getProductDetail().setProductId(product.getProductId());
		product.getProductDetail().setProduct(product);
		productDao.save(product);
	}
	
	public void updateProduct(Product product) {
		log.info("Inside ProductService --> updateProduct Method");
		product.setUpdatedTimeStamp(LocalDateTime.now());
		product.getProductDetail().setUpdatedTimeStamp(LocalDateTime.now());
		product.getProductDetail().setProductId(product.getProductId());
		productDao.save(product);
	}
}
