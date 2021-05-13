package com.spring.nemo.soap_service_demo_client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidatationException extends RuntimeException{

	public ValidatationException(String message) {
		super(message);
	}
}
