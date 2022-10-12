package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.entity.Login;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.PasswordNotSameException;

public interface ILoginService {
	
	LoginResponseDto login(LoginDto logindto) throws InvalidCredentialsException, PasswordNotSameException;
	LoginResponseDto logout(String email) throws EmailNotFoundException;
	Login getById(int id);
	Login updateLogin(String email,Login login);
	Login findByLoginEmail(String email);
}
