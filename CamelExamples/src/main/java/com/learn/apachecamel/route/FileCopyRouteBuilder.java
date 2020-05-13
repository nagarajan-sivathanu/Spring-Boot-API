package com.learn.apachecamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.apachecamel.constant.CamelEndPoints;

import lombok.Getter;

/* 
 * This Route to pick files from Input Location and copy them to Output Location.
 * noop=true option indicates it does not alter the input file
 * filName option denotes fileNames and we also can rename it while delivering.
 */

@Component
public class FileCopyRouteBuilder extends RouteBuilder{
	
	@Autowired @Getter 
	private CamelEndPoints camelEndPoints;
	
	@Override
	public void configure() throws Exception {
		from(camelEndPoints.fileInputEndPoint)
		.log("Input File Picked Up for Processing")
		.to(camelEndPoints.fileOutputEndPoint)
		.log("File Develired to Output Folder");
	}
}
