package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.exception.InvalidCredentialsException;

public interface ILoginService {
	
	LoginResponseDto login(LoginDto logindto) throws InvalidCredentialsException;
	LoginResponseDto logout(String email) throws EmailNotFoundException;

}
