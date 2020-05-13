package com.learn.apachecamel.route;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.apachecamel.constant.CamelEndPoints;
import com.learn.apachecamel.processor.DBAccessJDBCProcessor;
import lombok.Getter;

/* 
 * This Route will trigger from a timer. Period = 10000 indicates this to get triggered after 1 second.
 * repeatCount = 1 option will restrict repeatable trigger from this timer after every one second.
 * This will query the postgresql database through jdbc component and a processor is used to log the entries
 */

@Component
public class DBAccessJDBCRouteBuilder extends RouteBuilder{

	@Autowired @Getter
	private DataSource dataSource;
	
	@Autowired @Getter 
	private CamelEndPoints camelEndPoints;
	
	@Autowired
	private DBAccessJDBCProcessor processor;
	
	@Override
	public void configure() throws Exception {
		from(camelEndPoints.timer1EndPoint)
		.log("Invoked DBAccessJDBCRouteBuilder --> Timer")
		.setBody(constant("select * from task"))
		.to("jdbc:dataSource")
		.process(processor);
	}

}
