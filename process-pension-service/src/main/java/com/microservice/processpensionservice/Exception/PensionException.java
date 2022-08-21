package com.microservice.processpensionservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionException extends RuntimeException {
	private String message;
	private String code;

	public PensionException(String message) {
		super(message);
	}
}
