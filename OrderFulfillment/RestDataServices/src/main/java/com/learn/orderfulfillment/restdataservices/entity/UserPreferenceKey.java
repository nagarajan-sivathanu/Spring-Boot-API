package com.learn.orderfulfillment.restdataservices.entity;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
public class UserPreferenceKey implements Serializable{
	private static final long serialVersionUID = 1L;
	private BigInteger userId;
	private BigInteger productId;
}
