package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Specialization {
	
	@Id
	@GeneratedValue
	private int specilizationId;
	private String specName;

}
