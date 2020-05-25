package com.learn.orderfulfillment.restdataservices.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orderfulfillment.restdataservices.entity.Invoice;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice,BigInteger> {
	public List<Invoice> findAll();
}
