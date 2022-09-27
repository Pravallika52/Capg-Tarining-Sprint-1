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
public class Patient {

	@Id
	@GeneratedValue
	private int patientId;
	@NotEmpty(message ="Name may be Empty")
	private String patientName;
	@NotEmpty(message = "Email is mandatory")
	@Email
	private String patientEmail;
	private Double contact;
	@NotEmpty(message = "Must contain a Password")
	@Length(min=6, max=10)
	private String password;
	
}