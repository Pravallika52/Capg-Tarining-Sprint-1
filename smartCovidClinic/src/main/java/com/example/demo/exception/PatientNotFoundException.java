package com.example.demo.exception;

@SuppressWarnings("serial")
public class PatientNotFoundException extends Exception {
	
	public PatientNotFoundException(String msg) {
		super(msg);
	}

}