package com.learn.apachecamel.route;

import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.learn.apachecamel.constant.CamelEndPoints;

import lombok.Getter;

@Component
public class EmailRouterBuilder extends RouteBuilder {
	
	private static final String EMAIL_SUBJECT = "SUBJECT - TESTING EMAIL DELIVERY FROM " +
	  		"SPRING BOOT APP INTEGRATED WITH APACHE CAMEL";
	
	private static final String EMAIL_BODY_MESSAGE = "MESSAGE PAYLOAD - This message is to " +
	  	    "drafted to validate the email delivery triggered " +
	  	    " Spring Boot App integrated with Apache Camel. " +
	  	    " Reception of this email indicates SUCCESSFUL EMAIL DELIVERY";
	
	private static final String EMAIL_ATTACHMENT_PATH = "C:\\Users\\User\\Music\\Input\\File1.txt";
	
	Map<String,Object> emailHeaderMap = new HashMap<>();
	
	@Value(value="${email.from}") String emailFrom;
	@Value(value="${email.to}") String emailTo;
	
	@Autowired @Getter 
	private CamelEndPoints camelEndPoints;
	
	@Override
	public void configure() throws Exception {
		from(camelEndPoints.timer2Endpoint)
		  .log("Inside EmailRouterBuilder")
		  .process(exchange -> {
			  emailHeaderMap.put("From", emailFrom);
			  emailHeaderMap.put("To", emailTo);
			  emailHeaderMap.put("Subject", EMAIL_SUBJECT);
			  exchange.getIn().setHeaders(emailHeaderMap);
			  exchange.getIn().addAttachment("TestFile", new DataHandler(
					  new FileDataSource(EMAIL_ATTACHMENT_PATH)));
			  exchange.getIn().setBody(EMAIL_BODY_MESSAGE);
		  })
		  .to(camelEndPoints.emailDeliveryEndPoint);
	}

}
