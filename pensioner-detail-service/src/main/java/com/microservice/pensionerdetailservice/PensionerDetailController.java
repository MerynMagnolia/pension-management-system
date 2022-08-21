package com.microservice.pensionerdetailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PensionerDetailController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailController.class);

	@Autowired
	private PensionerDetailService pensionerService;

	@Autowired
	private AuthorizeProxy authorizeProxy;

	@GetMapping(value = "pensioner-detail")
	public PensionerDetail retrievePensionerDetail(@RequestHeader(name = "Authorization") String token,
			@RequestParam Long aadharNumber) throws Exception {
		LOGGER.info("START - RetrievePensionerDetail with Aadhar Number");
		try {
			authorizeProxy.authorization(token);
			PensionerDetail pensionerDetail = pensionerService.findByAadhar(aadharNumber);

			LOGGER.info("END - RetrievePensionerDetail with Aadhar Number");
			return pensionerDetail;

		} catch (Exception e) {
			LOGGER.error("EXCEPTION - RetrievePensionerDetail with Aadhar Number");
			throw new RuntimeException(e);
		}

	}

}
