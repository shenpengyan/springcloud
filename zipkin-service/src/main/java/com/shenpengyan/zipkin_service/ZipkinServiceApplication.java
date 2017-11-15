package com.shenpengyan.zipkin_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class ZipkinServiceApplication 
{
	private static Logger log = LoggerFactory.getLogger(ZipkinServiceApplication.class);
	
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(ZipkinServiceApplication.class).web(true).run(args);
    }
}
