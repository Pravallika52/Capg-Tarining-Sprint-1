package com.example.demo.dto;

import lombok.Data;

@Data
public class PatientOutputDto {

	private String patientName;
	private Double contact;
	private String loginEmail;
	private Boolean membership;
}