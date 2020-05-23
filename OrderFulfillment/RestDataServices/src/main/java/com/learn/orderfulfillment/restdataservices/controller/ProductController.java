package com.learn.orderfulfillment.restdataservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.orderfulfillment.restdataservices.entity.Product;
import com.learn.orderfulfillment.restdataservices.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	List<Product> products;
	@Autowired	private ProductService productService;
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		log.info("Inside ProductController --> getAllProducts Method");
		products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping(value="/products")
	public ResponseEntity<Product>  createProduct(@RequestBody Product product) {
		log.info("Inside ProductController --> createUser Method");
		productService.createProduct(product);	
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		log.info("Inside ProductController --> updateProduct Method");
		productService.updateProduct(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

}
