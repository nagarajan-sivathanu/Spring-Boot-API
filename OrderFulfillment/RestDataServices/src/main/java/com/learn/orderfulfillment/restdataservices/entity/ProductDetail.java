package com.learn.orderfulfillment.restdataservices.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="PRODUCT_DETAIL",schema = "OMSODSDEV01")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","updatedTimeStamp","product"})
@org.hibernate.annotations.GenericGenerator(name="product-primarykey", strategy="foreign",
parameters={@org.hibernate.annotations.Parameter(name="property", value="product")
})
public class ProductDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "product-primarykey")
	@Column(name = "PRODUCT_ID")
	private BigInteger productId;
	
	@Column(name = "PRICE_AMT")
	private BigInteger priceAmount;
	
	@Column(name = "AVAILABLE_QTY")
	private BigInteger availableQuantity;
	
	@Column(name = "STATUS_CD")
	private String statusCode;
	
	@Column(name = "UPDATED_TS")
	private LocalDateTime updatedTimeStamp;
	
	@JoinColumn(name = "STATUS_CD",nullable = false, insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	@Where(clause = "STATUS_CATEGORY=PRODUCT")
	Status status;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	Product product;
	
}
