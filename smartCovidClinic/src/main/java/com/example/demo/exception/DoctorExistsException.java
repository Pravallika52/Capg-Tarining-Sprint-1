package com.example.demo.exception;

@SuppressWarnings("serial")
public class DoctorExistsException extends Exception{
	
	public DoctorExistsException(String msg) {
		super(msg);
	}

}
