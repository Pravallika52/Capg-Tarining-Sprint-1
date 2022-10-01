package com.example.demo.exception;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends Exception{
	
	public InvalidCredentialsException(String msg) {
		super(msg);
	}

}
