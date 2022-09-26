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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
	
	
	@Id
	@GeneratedValue
	private int adminId;
	@NotEmpty(message="Please Enter a Name")
	private String adminName;
	@Email
	@NotEmpty(message="Please Enter an EmailId")
	private String adminEmail;
	@NotEmpty(message="Please Enter an Password")
	@Length(min=6,max=20)
	private String adminPassword;
	@NotEmpty(message="Please Enter the Password again")
	@Length(min=6,max=20)
	private String adminConfirmPassword;

}
