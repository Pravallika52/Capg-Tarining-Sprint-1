package com.example.demo.exception;

@SuppressWarnings("serial")
public class DoctorNotFoundException extends Exception{
	public DoctorNotFoundException(String msg) {
		super(msg);
	}

}
