package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginRespDto;
import com.example.demo.entity.Login;
import com.example.demo.exception.EmailNotFoundException;

public interface ILoginService {
	
	LoginRespDto login(LoginDto logindto);
	LoginRespDto logout(String email) throws EmailNotFoundException;

}
