package com.learn.apachecamel.constant;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.springframework.stereotype.Component;

import lombok.Getter;


@Getter
@Component
public class CamelEndPoints {

	@EndpointInject(uri = "jmsComponent:{{jms.queue.inputQueue}}{{jms.listenerArguments}}")
	public Endpoint inputQueueJMSEndPoint;
	
	@EndpointInject(uri = "jmsComponent:{{jms.queue.outputQueue}}{{jms.listenerArguments}}")
	public Endpoint outputQueueJMSEndPoint;
	
	@EndpointInject(uri = "timer://timer1?period=10000&repeatCount=1")
	public Endpoint timer1EndPoint;
	
	@EndpointInject(uri = "timer://timer1?period=20000&repeatCount=1")
	public Endpoint timer2Endpoint;
	
	@EndpointInject(uri = "file://C://Users//User//Music//Input?fileName=File2.txt")
	public Endpoint fileInputEndPoint;
	
	@EndpointInject(uri = "file://E://Shared Folder//TestFolder?fileName=testFileFromWindows.txt")
	public Endpoint fileOutputEndPoint;
	
	
	@EndpointInject(uri = "sftp:root@127.0.0.1:2222/home/nagarajan/Downloads/input?" + 
			"fileName=testFileFromWindows.txt&password=****")
	public Endpoint fileSFTPEndPoint;
	
	@EndpointInject(uri = "smtps://smtp.gmail.com:465?" +
			 "username=emailhostID&password=******&debugMode=true")
	public Endpoint emailDeliveryEndPoint;
}
