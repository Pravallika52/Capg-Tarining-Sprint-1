package com.example.demo.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.entity.Login;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.service.ILoginService;


@RestController
@CrossOrigin(origins="http://localhost:3000/")
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
	
	@GetMapping("/login/get/{id}")
	ResponseEntity<Login> getById(@PathVariable int id){
		Login log=loginServ.getById(id);
		return new ResponseEntity<>(log,HttpStatus.OK);
	}
	
	@PutMapping("/login/forgotPassword/{id}")
	ResponseEntity<Login> updateLogin(@PathVariable String id, @RequestBody Login login){
		Login log=loginServ.updateLogin(id, login);
		return new ResponseEntity<>(log,HttpStatus.OK);
	}
	
	@GetMapping("/login/getEmail/{email}")
	ResponseEntity<Login> getByEmail(@PathVariable String email){
		Login log=loginServ.findByLoginEmail(email);
		return new ResponseEntity<>(log,HttpStatus.OK);
	}
	
}