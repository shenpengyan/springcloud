package com.shenpengyan.order_service.feign;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceFeignDAOHystrix implements ProductServiceFeignDAO{

	@Override
	public String hello() {
		return "服务不见了，稍后再试";
	}

}
