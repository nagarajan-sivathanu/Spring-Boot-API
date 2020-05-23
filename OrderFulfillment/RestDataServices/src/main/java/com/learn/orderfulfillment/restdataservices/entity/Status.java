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
@Table(name ="STATUS",schema = "OMSODSDEV01")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","updatedTimeStamp"})
public class Status implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "STATUS_CD")
	private String statusCode;
	
	@Column(name = "STATUS_CATEGORY")
	private String statusCategory;
	
	@Column(name = "STATUS_DESC")
	private String statusDescription;
	
	@Column(name = "UPDATED_TS")
	private LocalDateTime updatedTimeStamp;
}
