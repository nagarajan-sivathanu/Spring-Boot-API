package com.learn.mongoDB.pojo;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class FemaleCount {
	@Id
	private String state;
	private String totalFemale;
}
