package com.learn.orderfulfillment.restdataservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.orderfulfillment.restdataservices.dao.InvoiceDao;
import com.learn.orderfulfillment.restdataservices.dao.InvoiceProductRelDao;
import com.learn.orderfulfillment.restdataservices.entity.Invoice;

@Service
@Transactional
public class InvoiceService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired private InvoiceDao invoiceDao;
	@Autowired private InvoiceProductRelDao invoiceProductRelDao;
	
	public List<Invoice> getAllInvoices(){
		log.info("Inside InvoiceService --> getAllInvoices Method");
		List<Invoice> invoices = new ArrayList<>();
		invoiceDao.findAll().forEach(invoices::add);
		return invoices;	
	}
	
	public void createInvoice(Invoice invoice) {
		log.info("Inside InvoiceService --> createInvoice Method"); 
		invoice.setUpdatedTimeStamp(LocalDateTime.now());
		invoice.getInvoiceProductRel().stream().forEach(i->{
			i.getInvoiceProductRelKey().setInvoice(invoice);
			i.setUpdatedTimeStamp(LocalDateTime.now());
		});
		invoiceDao.save(invoice);
	}
}
