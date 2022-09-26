package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
	
	@Id
	@Email(message="Enter valid email address")
	private String loginEmail;
	private String loginPassword;
	private boolean isLoggedIn = false;
	

}
