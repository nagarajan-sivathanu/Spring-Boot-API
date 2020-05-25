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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.orderfulfillment.restdataservices.entity.Invoice;
import com.learn.orderfulfillment.restdataservices.service.InvoiceService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InvoiceController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	List<Invoice> invoices;
	@Autowired	private InvoiceService invoiceService;
	
	@GetMapping(value = "/invoice")
	public ResponseEntity<List<Invoice>> getAllInvoices() {
		log.info("Inside InvoiceController --> getAllInvoices Method");
		invoices = invoiceService.getAllInvoices();
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}
	
	@PostMapping(value="/invoice")
	public ResponseEntity<Invoice>  createInvoice(@RequestBody Invoice invoice) {
		log.info("Inside InvoiceController --> createInvoice Method");
		invoiceService.createInvoice(invoice);
		return new ResponseEntity<>(invoice, HttpStatus.CREATED);
	}
	
}
