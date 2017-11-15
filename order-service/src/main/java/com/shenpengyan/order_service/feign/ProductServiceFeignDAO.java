package com.shenpengyan.order_service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="product-service", fallback = ProductServiceFeignDAOHystrix.class)
public interface ProductServiceFeignDAO {
	
	@RequestMapping(method = RequestMethod.GET, value="/hello")
	String hello();
}
