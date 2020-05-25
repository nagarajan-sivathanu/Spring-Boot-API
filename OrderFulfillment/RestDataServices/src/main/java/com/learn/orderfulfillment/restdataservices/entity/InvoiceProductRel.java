package com.learn.orderfulfillment.restdataservices.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="INVOICE_PRODUCT_REL",schema = "OMSODSDEV01")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","updatedTimeStamp"})
public class InvoiceProductRel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private InvoiceProductRelKey invoiceProductRelKey;
	
	@Column(name = "ORDER_QTY")
	private BigInteger orderQuantity;
	
	@Column(name = "PRICE_AMT")
	private BigInteger priceAmount;
	
	@Column(name = "UPDATED_TS")
	private LocalDateTime updatedTimeStamp;
	
}
