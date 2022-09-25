package com.example.demo.exception;

@SuppressWarnings("serial")
public class DoctorNotFoundException extends Exception{

	public DoctorNotFoundException(String message) {
		super(message);
	}
}