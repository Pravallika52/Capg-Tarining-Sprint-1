package com.example.demo.dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.TimeSlot1;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PatientAppointmentDto {
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	
	@Enumerated(EnumType.STRING)
	private TimeSlot1 timeSlot1;
	
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="appointment_doctor_id")
	private Doctor doctor;

}
