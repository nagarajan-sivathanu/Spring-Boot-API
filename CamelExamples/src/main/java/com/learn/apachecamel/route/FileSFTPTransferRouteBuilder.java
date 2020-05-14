package com.learn.apachecamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.apachecamel.constant.CamelEndPoints;

import lombok.Getter;

@Component
public class FileSFTPTransferRouteBuilder extends RouteBuilder {
	
	@Autowired @Getter 
	private CamelEndPoints camelEndPoints;
	
	private StringBuilder sftpURL= new StringBuilder("sftp:")
				.append("root")
				.append("@")
				.append("127.0.0.1")
				.append(":")
				.append("2222")
				.append("/home/nagarajan/Downloads/input")
				.append("?")
				.append("fileName=testFileFromWindows.txt")
				.append("&")
				.append("password=*****");
	
	@Override
	public void configure() throws Exception {
		from(camelEndPoints.fileOutputEndPoint)
		.log("File Picked Up for SFTP Transfer")
		.toD(sftpURL.toString())
		.to("log:com.learn.apachecamel.route.FileSFTPTransferRouteBuilder?level=TRACE")
		.log("File Delivered to Downstream System Successfully");
	}

}
