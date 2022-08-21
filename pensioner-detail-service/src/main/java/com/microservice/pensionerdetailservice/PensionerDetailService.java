package com.microservice.pensionerdetailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PensionerDetailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailService.class);

	@Autowired
	private PensionerDetailRepository pensionerRepo;

	public PensionerDetail findByAadhar(Long aadharNumber) {
		LOGGER.info("START - PensionerDetailService -findByAadhar");

		PensionerDetail pensionerDetail = pensionerRepo.findByAadharNumber(aadharNumber);
		
		return pensionerDetail;


	}

}
