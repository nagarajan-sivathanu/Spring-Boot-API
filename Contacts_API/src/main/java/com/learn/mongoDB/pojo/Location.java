package com.learn.mongoDB.pojo;

import lombok.Data;

@Data
public class Location {
	private String street;
	private String city;
	private String state;
	private String postcode;
	private Coordinates coordinates;
	private Timezone timezone;
}
