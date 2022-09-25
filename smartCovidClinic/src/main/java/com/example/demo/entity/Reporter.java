package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reporter {
	
	@Id
	@GeneratedValue
	private int reporterId;

}
