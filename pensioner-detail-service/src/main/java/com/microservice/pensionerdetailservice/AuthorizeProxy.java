package com.microservice.pensionerdetailservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "jwt-microservice", url = "${JWT_URI:http://localhost:8080}")
public interface AuthorizeProxy {
	
	@GetMapping("/api/jwt-microservice/authorize")
	public Boolean authorization(@RequestHeader("Authorization") String token);

}
