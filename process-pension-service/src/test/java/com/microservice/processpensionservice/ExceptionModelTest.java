package com.microservice.processpensionservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.microservice.processpensionservice.Exception.ExceptionResponse;
import com.microservice.processpensionservice.Exception.PensionException;

class ExceptionModelTest {
	
	@Test
	void testNoArgsPensionExceptionTest() {
		assertThat(new PensionException()).isNotNull();
	}

	@Test
	void testAllArgsPensionExceptionTest() {
		PensionException pensionExceptions = new PensionException("Err Message", "Err Code");
		assertNotNull(pensionExceptions);
	}
	
	@Test
	void testNoArgsExceptionResponseTest() {
		assertThat(new ExceptionResponse()).isNotNull();
	}

	@Test
	void testAllArgsExceptionResponseTest() {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Err Message", "Err Code");
		assertNotNull(exceptionResponse);
	}
	
	@Test
	void testPensionerExpTest() {
		PensionException pExp = new PensionException();
		pExp.setMessage("Invalid Aadhar");
		pExp.setCode("404 Not found");
		
		assertEquals("Invalid Aadhar", pExp.getMessage());
		assertEquals("404 Not found", pExp.getCode());
	}
		
	@Test
	void testExceptionResponseTest() {
		ExceptionResponse expRep = new ExceptionResponse();
		expRep.setMessage("Invalid Aadhar");
		expRep.setCode("404 Not found");
		
		assertEquals("Invalid Aadhar", expRep.getMessage());
		assertEquals("404 Not found", expRep.getCode());
	}
	
	

}
