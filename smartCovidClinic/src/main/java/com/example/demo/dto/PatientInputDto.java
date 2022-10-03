package com.example.demo.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.demo.entity.Ailment1;

import lombok.Data;

@Data
public class PatientInputDto {
	
	private String patientName;
	private Double contact;
	private LoginDto login;
	@Enumerated(EnumType.STRING)
	private Ailment1 ailment1;
	@Enumerated(EnumType.STRING)
	private Ailment1 ailment2;
	@Enumerated(EnumType.STRING)
	private Ailment1 ailment3;
	private boolean memberShip; 
	
}
