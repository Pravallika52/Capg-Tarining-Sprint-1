package com.example.demo.exception;

@SuppressWarnings("serial")
public class PatientExistsException extends Exception{
	public PatientExistsException(String msg) {
		super(msg);
	}


}
