package com.example.demo.exception;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends RuntimeException {
	public InvalidCredentialsException(String message) {
		super(message);
	}

}
