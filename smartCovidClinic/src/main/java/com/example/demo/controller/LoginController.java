package com.example.demo.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.service.ILoginService;


@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	ILoginService loginServ;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/login/dto")
	ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) throws InvalidCredentialsException, PasswordNotSameException{
		logger.info("Sending request to Login");
		LoginResponseDto login= loginServ.login(loginDto);
		logger.info("Login Successful");
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PatchMapping("/logout/{email}")
	ResponseEntity<LoginResponseDto> logout(@PathVariable String email) throws EmailNotFoundException {
		LoginResponseDto resp = loginServ.logout(email);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
}