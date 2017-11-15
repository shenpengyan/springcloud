package com.shenpengyan.config_service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigServiceApplication.class).web(true).run(args);
	}
	
}
