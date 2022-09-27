package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

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
	private int repoId;
	
	@NotEmpty(message="Please Enter a Name")
	private String repoName;
	
	@Email
	@NotEmpty(message="Please Enter a EmailId")
	private String email;
	
	private String phNo;

}
