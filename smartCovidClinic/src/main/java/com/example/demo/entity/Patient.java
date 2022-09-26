package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private String patientName;
	private String patientEmail;
	private double patientContact;
	private String patientPassword;

}
