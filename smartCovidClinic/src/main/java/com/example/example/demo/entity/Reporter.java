package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	private String reporterContact;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Login login;

}
