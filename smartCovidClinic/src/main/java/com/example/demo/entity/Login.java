package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Login {
	
	@Id
	@GeneratedValue
	private int id;
	@Email(message="Enter valid email address")
	private String loginEmail;
	@NotEmpty(message="Please Enter a Password")
	@Length(min=6,max=20)
	private String loginPassword;
	private String role ;
	private boolean isLoggedIn = false;
	

}
