package com.learn.orderfulfillment.restdataservices.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="INVOICE",schema = "OMSODSDEV01")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","updatedTimeStamp"})
public class Invoice implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="invoiceNbrSequence")
	@SequenceGenerator(name="invoiceNbrSequence",schema = "OMSODSDEV01",sequenceName="INVOICE_NBR_SEQ",allocationSize = 1)
	@Column(name = "INVOICE_NBR")
	private BigInteger invoiceNbr;
	
	@Column(name = "USER_ID")
	private BigInteger userId;
	
	@JoinColumn(name = "USER_ID",nullable = false, insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Column(name = "INVOICE_BILL")
	private BigInteger invoiceBillAmount;
	
	@Column(name = "INVOICE_STATUS_CD")
	private String statusCode;
	
	@Column(name = "UPDATED_TS")
	private LocalDateTime updatedTimeStamp;
	
	@JoinColumn(name = "INVOICE_STATUS_CD",referencedColumnName = "STATUS_CD",nullable = false, insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	@Where(clause = "STATUS_CATEGORY=INVOICE")
	private Status status;
	
	@OneToMany(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY, mappedBy = "invoiceProductRelKey.invoice")
	private List<InvoiceProductRel> invoiceProductRel;
	
}
