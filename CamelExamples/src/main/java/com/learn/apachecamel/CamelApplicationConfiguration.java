package com.learn.apachecamel;

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.learn.apachecamel"})
public class CamelApplicationConfiguration {
	
   /*
	* DATASOURCE Bean Configuration - POSTGRESQL
	*/
	@Bean
	@Primary
	@Autowired
	public DataSource dataSource(
			@Value("${spring.datasource.url}") String url,
			@Value("${spring.datasource.driverClassName}") String driverClassName,
			@Value("${spring.datasource.username}") String userName,
			@Value("${spring.datasource.password}") String password) {
		
		DataSourceBuilder<?> bean = DataSourceBuilder.create();
		bean.url(url);
		bean.driverClassName(driverClassName);
		bean.username(userName);
		bean.password(password);
		return bean.build();
	}
	
   /*
	* ACTIVE MQ Connection Factory
	*/
	@Bean
	@Primary
	@Autowired
	public ConnectionFactory connectionFactory(
			@Value("${spring.activemq.broker-url}") String brokerUrl,
			@Value("${spring.activemq.user}") String user,
			@Value("${spring.activemq.password}") String password) {
		return new ActiveMQConnectionFactory(user, password, brokerUrl);
	}
	
   /*
	* JMS Component Bean
	*/
	@Bean
	@Autowired
	public JmsComponent jmsComponent(
			final ConnectionFactory connectionFactory) {
		JmsComponent jmsComponent = JmsComponent.jmsComponent(connectionFactory);
		jmsComponent.setAsyncConsumer(true);
		return jmsComponent;
	}
	
}
