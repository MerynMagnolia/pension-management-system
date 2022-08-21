package com.microservice.processpensionservice.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler
		extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

	    @ExceptionHandler(PensionException.class)
	    protected ResponseEntity<Object> handleGlobalException(PensionException pensionExp) {
	        return ResponseEntity
	                .badRequest()
	                .body(ExceptionResponse.builder()
	                        .code(pensionExp.getCode())
	                        .message(pensionExp.getMessage())
	                        .build());
	    }
	}

