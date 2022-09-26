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
public class Reporter {
	
	@Id
	@GeneratedValue
	private int reporterId;

	private String reporterName;
	private String reporterEmail;
	private String reporterContact;

}
