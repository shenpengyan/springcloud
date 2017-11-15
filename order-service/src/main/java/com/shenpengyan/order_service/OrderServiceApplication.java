package com.shenpengyan.order_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shenpengyan.order_service.feign.ProductServiceFeignDAO;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
@RestController
public class OrderServiceApplication {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	ProductServiceFeignDAO productServiceFeignDAO;
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(OrderServiceApplication.class).web(true).run(args);
	}

	@Value("${configParam}")
	private String configParam;
	
	public String getConfigParam() {
		return configParam;
	}


	public void setConfigParam(String configParam) {
		this.configParam = configParam;
	}


	@RequestMapping(value = "/configParam", method = RequestMethod.GET)
	public String configParam() {
		return this.configParam;
	}
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		logger.info("order service calling product service");
		return productServiceFeignDAO.hello();
	}
		
	@RequestMapping(value = "/product/hello", method = RequestMethod.GET)
	public String helloProductService() {
		logger.info("order service calling product service");
		return productServiceFeignDAO.hello();
	}
	
}
