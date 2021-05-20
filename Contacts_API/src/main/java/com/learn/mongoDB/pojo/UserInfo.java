package com.learn.mongoDB.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "contacts")
public class UserInfo {
	@Id
	private String _id;
	private String gender;
	private Name name;
	private Location location;
	private String email;
	private Login login;
	private DOB dob;
	private RegisteredInfo registeredInfo;
	private String phone;
	private String cell;
	private ID id;
	private Picture picture;
	private String nat;
}
