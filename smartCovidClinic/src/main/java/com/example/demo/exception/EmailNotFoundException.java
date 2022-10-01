package com.example.demo.exception;

@SuppressWarnings("serial")
public class EmailNotFoundException extends Exception{
	
	public EmailNotFoundException(String msg) {
		super(msg);
	}

}
