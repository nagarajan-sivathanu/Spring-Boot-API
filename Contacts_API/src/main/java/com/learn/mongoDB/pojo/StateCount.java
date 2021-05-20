package com.learn.mongoDB.pojo;

import lombok.Data;

@Data
public class StateCount {
	
	private String state;
	private String femaleCount;
	private String maleCount;
	private String totalPopulation;
}
