package com.example.demo.exception;

@SuppressWarnings("serial")
public class AppointmentNotFoundException extends Exception{
	
	public AppointmentNotFoundException(String msg) {
		super(msg);
	}

}