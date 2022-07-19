package com.example.microservices.UserExample.exceptionHandler;

public class ApiException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ApiException(String message) {
		super(message);
	}
}