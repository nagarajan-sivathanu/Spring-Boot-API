package com.learn.orderfulfillment.restdataservices.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="USER_ROLE",schema = "OMSODSDEV01")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","updatedTimeStamp"}) 
public class UserRole implements Serializable {	

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USER_ROLE_CD")
	private String userRoleCode;
	
	@Column(name = "USER_ROLE_DESC")
	private String userRoleDesc;
	
	@Column(name = "UPDATED_TS")
	private LocalDateTime updatedTimeStamp;
	
}
