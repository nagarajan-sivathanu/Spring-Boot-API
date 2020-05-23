package com.learn.orderfulfillment.restdataservices.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="USER",schema = "OMSODSDEV01")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"updatedTimeStamp"})
public class User implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userIDSequence")
	@SequenceGenerator(name="userIDSequence",sequenceName="USER_ID_SEQ",allocationSize = 1)
	@Column(name = "USER_ID")
	private BigInteger userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "MOBILE")
	private BigInteger mobile;
	
	@Column(name = "USER_ROLE_CD")
	private String userRoleCode;
	
	@Column(name = "AGE")
	private BigInteger age;
	
	@Column(name = "UPDATED_TS")
	private LocalDateTime updatedTimeStamp;
	
	@JoinColumn(name = "USER_ROLE_CD",nullable = false, insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.LAZY)
	UserRole userRole;

}
