package com.shenpengyan.loadbalance_service.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadbalanceController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/product/hello", method = RequestMethod.GET)
	public String productHello() {
		return restTemplate.getForEntity("http://PRODUCT-SERVICE/hello", String.class).getBody();
	}

	@RequestMapping(value = "/order/hello", method = RequestMethod.GET)
	public String orderHello() {
		logger.info("loadbalance calling Order service");
		return restTemplate.getForEntity("http://ORDERSERVICE/hello", String.class).getBody();
	}
	
	
}
