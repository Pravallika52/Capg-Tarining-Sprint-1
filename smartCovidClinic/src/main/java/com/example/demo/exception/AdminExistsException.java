package com.example.demo.exception;

@SuppressWarnings("serial")
public class AdminExistsException extends Exception{
	public AdminExistsException(String msg) {
		super(msg);
	}

}
