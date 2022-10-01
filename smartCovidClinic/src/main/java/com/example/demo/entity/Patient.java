package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

	@Id
	@GeneratedValue
	private int patientId;
	
	@NotEmpty(message ="Name may be Empty")
	private String patientName;
	
	private Double contact;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_login_id")
	
	private Login login;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
	@JoinTable(name="patient_ailment", joinColumns= {@JoinColumn(name="patient_id")},
	inverseJoinColumns= {@JoinColumn(name="ailment_id")})
	private List<Ailment> ailment;
	
	@Enumerated(EnumType.STRING)
	private Ailment1 ailment1;
	
	private boolean memberShip; 
	
	
	
}