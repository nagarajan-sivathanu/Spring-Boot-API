package com.learn.orderfulfillment.restdataservices.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.learn.orderfulfillment.restdataservices.entity.Product;
import com.learn.orderfulfillment.restdataservices.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="USER_PREFERENCE",schema = "OMSODSDEV01")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"updatedTimeStamp"})
@IdClass(UserPreferenceKey.class)
public class UserPreference implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USER_ID")
	private BigInteger userId;
	@Id
	@Column(name = "PRODUCT_ID")
	private BigInteger productId;
	
	@JoinColumn(name = "USER_ID",nullable = false, insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name = "PRODUCT_ID",nullable = true, insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	private Product product;
	
	@Column(name = "UPDATED_TS")
	private LocalDateTime updatedTimeStamp;
	
	@Transient
	private String statusCode;
}
