package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Appointment;
import com.example.demo.service.IAppointmentService;


@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointService;
	
	@PostMapping("/appoint/add")
	ResponseEntity<Appointment> addAppoint(Appointment appoint) {
		Appointment newappoint = appointService.addAppoint(appoint);
		return new ResponseEntity<>(newappoint, HttpStatus.CREATED);
	}
	
	@GetMapping("/appoint/getall/")
	ResponseEntity<List<Appointment>> getAllAppoint(){
		List<Appointment> allappoint = appointService.getAllAppoint();
		return new ResponseEntity<>(allappoint, HttpStatus.OK);
	}
	
	@GetMapping("/appoint/view/{appointId}")
	ResponseEntity<Appointment> viewAppoint(@PathVariable("appointId") int appointId) {
		Appointment appoint = appointService.viewAppoint(appointId);
		return new ResponseEntity<>(appoint, HttpStatus.OK);
		
	}
	

}
