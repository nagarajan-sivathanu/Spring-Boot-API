package com.learn.orderfulfillment.restdataservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.orderfulfillment.restdataservices.entity.InvoiceProductRel;
import com.learn.orderfulfillment.restdataservices.entity.InvoiceProductRelKey;

@Repository
public interface InvoiceProductRelDao extends JpaRepository<InvoiceProductRel,InvoiceProductRelKey>{
	public List<InvoiceProductRel> findAll();
}
