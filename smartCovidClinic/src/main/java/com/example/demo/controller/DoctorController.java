package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Appointment;
import com.example.demo.service.IAppointmentService;

@RestController
public class DoctorController {

	@Autowired
	IAppointmentService appointServ;
	
	@GetMapping("doctor/getAllAppointments")
	ResponseEntity<List<Appointment>> getAllAppointment(){
		List<Appointment> appointments=appointServ.getAllAppoint();
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}
}
