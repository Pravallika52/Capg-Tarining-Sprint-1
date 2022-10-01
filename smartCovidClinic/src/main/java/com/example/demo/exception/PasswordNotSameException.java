package com.example.demo.exception;

@SuppressWarnings("serial")
public class PasswordNotSameException extends Exception{
	public PasswordNotSameException(String msg) {
		super(msg);
	}

}
