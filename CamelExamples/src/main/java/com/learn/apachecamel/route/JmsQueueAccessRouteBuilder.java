package com.learn.apachecamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.apachecamel.constant.CamelEndPoints;
import com.learn.apachecamel.vo.JmsEventVo;

import lombok.Getter;

@Component
public class JmsQueueAccessRouteBuilder extends RouteBuilder {
	
	@Autowired @Getter 
	private CamelEndPoints camelEndPoints;
	
	@Override
	public void configure() throws Exception {
		from(camelEndPoints.inputQueueJMSEndPoint)
		.log("Message Read From Input Queue")
		.unmarshal().json(JsonLibrary.Jackson,JmsEventVo.class)
		.process(exchange -> {
			JmsEventVo jmsEventVo = exchange.getIn().getBody(JmsEventVo.class);
			jmsEventVo.setEventName("PROCESS B");
			exchange.getIn().setBody(jmsEventVo);
		})
		.log("Before Triggering Output Queue")
		.marshal().json(JsonLibrary.Jackson)
		.to(camelEndPoints.outputQueueJMSEndPoint);		
	}

}
