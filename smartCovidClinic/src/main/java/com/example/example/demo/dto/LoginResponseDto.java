package com.example.demo.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
	
	private int id;
	private String name;
	private boolean isLoggedIn;
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}

}