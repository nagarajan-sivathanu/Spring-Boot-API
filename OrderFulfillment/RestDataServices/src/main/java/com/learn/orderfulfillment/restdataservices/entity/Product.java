package com.learn.orderfulfillment.restdataservices.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="PRODUCT",schema = "OMSODSDEV01")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","updatedTimeStamp"})
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="productIDSequence")
	@SequenceGenerator(name="productIDSequence",sequenceName="PRODUCT_ID_SEQ",allocationSize = 1)
	@Column(name = "PRODUCT_ID")
	private BigInteger productId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRODUCT_CATEGORY")
	private String productCategory;
	
	@Column(name = "PRODUCT_DESC")
	private String productDescription;
	
	@Column(name = "UPDATED_TS")
	private LocalDateTime updatedTimeStamp;

	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private ProductDetail productDetail;
}
