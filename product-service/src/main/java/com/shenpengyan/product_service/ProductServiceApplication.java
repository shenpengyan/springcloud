package com.shenpengyan.product_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ProductServiceApplication {
	Logger logger = LoggerFactory.getLogger(getClass());

	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ProductServiceApplication.class).web(true).run(args);
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {
		logger.info("called by order service");
		return new ResponseEntity<>("hello product service1", HttpStatus.OK);
	}
}
