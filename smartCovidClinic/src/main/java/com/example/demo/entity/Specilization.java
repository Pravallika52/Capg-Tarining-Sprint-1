package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Specilization {
	
	@Id
	@GeneratedValue
	private int specilizationId;

}
