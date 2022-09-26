package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue
	private int appId;
	private String appDate;
	private String appTime;
	//private Doctor appDoc;
	//private Patient appPatient;

}
