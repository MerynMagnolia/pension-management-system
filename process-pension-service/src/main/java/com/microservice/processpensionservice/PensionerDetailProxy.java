package com.microservice.processpensionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.processpensionservice.Exception.CustomFeignClientConfiguration;

@FeignClient(name="pensioner-detail-microservice", url = "${PENSIONER_DETAIL_URI:http://localhost:8000}", configuration = CustomFeignClientConfiguration.class)
public interface PensionerDetailProxy {

	@GetMapping("/api/pensioner-detail-microservice/pensioner-detail")
	public ProcessPension retrievePensionerDetail(@RequestHeader(name = "Authorization") String token,@RequestParam Long aadharNumber);

}
