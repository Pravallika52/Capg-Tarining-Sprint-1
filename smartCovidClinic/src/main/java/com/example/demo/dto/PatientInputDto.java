package com.example.demo.dto;

import lombok.Data;

@Data
public class PatientInputDto {
	
	private String patientName;
	private Double contact;
	private LoginDto login;
	private boolean memberShip;
	public boolean getMemberShip() {
		// TODO Auto-generated method stub
		return memberShip;
	} 
	
}
