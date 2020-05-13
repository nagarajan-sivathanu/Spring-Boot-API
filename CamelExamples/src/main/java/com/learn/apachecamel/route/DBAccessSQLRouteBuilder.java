package com.learn.apachecamel.route;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.apachecamel.constant.CamelEndPoints;
import com.learn.apachecamel.processor.DBAccessJDBCProcessor;

import lombok.Getter;

/*The jdbc: component allows you to access a database using JDBC, 
 * whereas the Select query and operations (UPDATE, INSERT, DELETE etc.) 
 * send messages in bodies.
 * 
 * The sql: component allows you to work with databases using JDBC queries. 
 * The difference between this component and the JDBC component is that, 
 * with SQL, the query is a property of the endpoint, and it uses message 
 * payloads as parameters passed to the query.
 */
@Component
public class DBAccessSQLRouteBuilder extends RouteBuilder{

	@Autowired @Getter
	private DataSource dataSource;
	
	@Autowired @Getter 
	private CamelEndPoints camelEndPoints;
	
	@Autowired
	private DBAccessJDBCProcessor processor;
	
	@Override
	public void configure() throws Exception {
		from(camelEndPoints.timer2Endpoint)
		.log("Invoked DBAccessSQLRouteBuilder --> Timer")
		.to("sql:select * from task where task_id<3?dataSource=dataSource")
		.log("${body}")
		.process(processor);
	}

}
