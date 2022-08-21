package com.microservice.processpensionservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidAadharException extends PensionException {
	public InvalidAadharException(String msg) {
		super(msg, "Aadhar not found");
	}
}
