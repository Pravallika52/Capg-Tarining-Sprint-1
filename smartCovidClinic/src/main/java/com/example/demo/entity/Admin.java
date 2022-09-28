package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
	
	
	@Id
	@GeneratedValue
	private int adminId;
	@NotEmpty(message="Please Enter a Name")
	private String adminName;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Login login;

}
