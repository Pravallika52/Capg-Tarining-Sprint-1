package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.entity.ErrorResponse;

@ControllerAdvice
public class AdministratorExceptionHandler {
	
	@ExceptionHandler(AdministratorNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(AdministratorNotFoundException exception) {
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); //404 not found
		error.setMessage(exception.getMessage());  // get message from exception
		error.setTimeStamp(LocalDateTime.now());	// system time
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);  	//404 not found
	}
	
	
	@ExceptionHandler(AdministratorFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(AdministratorFoundException exception) {
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.FOUND.value()); //302  found
		error.setMessage(exception.getMessage());  // get message from exception
		error.setTimeStamp(LocalDateTime.now());	// system time
		
		return new ResponseEntity<>(error,HttpStatus.FOUND);  	//302  found
	}
	
	
	@ExceptionHandler(PasswordNotSameException.class)
	public ResponseEntity<ErrorResponse> handleException(PasswordNotSameException exception) {
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value()); //302  found
		error.setMessage(exception.getMessage());  // get message from exception
		error.setTimeStamp(LocalDateTime.now());	// system time
		
		return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);  	//302  found
	
	}
	
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(PatientNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}

}
