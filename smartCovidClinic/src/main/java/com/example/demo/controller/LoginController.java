package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginRespDto;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.service.ILoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	ILoginService loginServ;
	@PostMapping("/login/dto")
	ResponseEntity<LoginRespDto> login(@RequestBody LoginDto loginDto){
		LoginRespDto login= loginServ.login(loginDto);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	@PatchMapping("/logout/{email}")
	ResponseEntity<LoginRespDto> logout(@PathVariable String email) throws EmailNotFoundException {
		LoginRespDto resp = loginServ.logout(email);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
}
