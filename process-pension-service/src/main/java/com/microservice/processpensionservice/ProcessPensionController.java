package com.microservice.processpensionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.processpensionservice.Exception.InvalidAadharException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProcessPensionController {

	@Autowired
	private PensionerDetailProxy proxy;

	@Autowired
	private AuthorizeProxy authorizeProxy;

	@Autowired
	private ProcessPensionService processPensionService;

	@PostMapping(value = "process-pension-feign", consumes = { "*/*" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProcessPension> calculatePensionAmt(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPension processPension) {

		try {
			authorizeProxy.authorization(token);
			Long aadhar = processPension.getAadharNumber();
			System.out.println("Aadhar" + aadhar);
			ProcessPension pension = proxy.retrievePensionerDetail(token, aadhar);
			if (pension == null) {
				throw new InvalidAadharException(
						"Invalid pensioner detail provided, please provide valid detail. Aadhar Number : " + aadhar);
			} else {
				ProcessPension pensionOutput = processPensionService.calculatePension(pension);
				System.out.println("Pension Amt: " + pensionOutput.getPensionAmount());
				return new ResponseEntity<ProcessPension>(pensionOutput, HttpStatus.OK);

			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
