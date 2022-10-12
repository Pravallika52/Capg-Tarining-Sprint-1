package com.example.demo.entity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.dto.DoctorDto;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@Enumerated(EnumType.STRING)
	private Ailment1 ailment1;
	
	@Enumerated(EnumType.STRING)
	private Ailment1 ailment2;
	
	@Enumerated(EnumType.STRING)
	private Ailment1 ailment3;
	
	private boolean memberShip; 
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	
	@Enumerated(EnumType.STRING)
	private TimeSlot1 timeSlot1;
	
	private String doctor;
	
	public Boolean getMemberShip() {
		return memberShip;
	}

	
	
	
}