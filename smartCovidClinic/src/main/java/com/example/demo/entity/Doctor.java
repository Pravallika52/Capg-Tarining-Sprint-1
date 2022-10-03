package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue
	private int doctorId;
	private String doctorName;
	
//	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
//	@JoinTable(name="doctor_specialization", joinColumns= {@JoinColumn(name="doctor_id")}, inverseJoinColumns= {@JoinColumn(name="specialization_id")})
//	private List<Specialization> specialization;
	
	@Enumerated(EnumType.STRING)
	private Specialization1 spec;
	
	private boolean doctorAvailable;


}
