package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.entity.ErrorResponse;

@ControllerAdvice
public class SpecExceptionHandler {
	
	@ExceptionHandler(SpecNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(SpecNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(SpecExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(SpecExistsException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.FOUND.value());
		error.setMessage(exception.getMessage()); 
		error.setTimeStamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(error, HttpStatus.FOUND); 
	}
	
	@ExceptionHandler(AppointNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(AppointNotFoundException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage()); 
		error.setTimeStamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
	

}
