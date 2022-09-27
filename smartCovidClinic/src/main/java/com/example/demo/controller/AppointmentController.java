package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Appointment;
import com.example.demo.exception.AppointNotFoundException;
import com.example.demo.service.IAppointmentService;


@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointService;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/appoint/add")
	ResponseEntity<Appointment> addAppoint(Appointment appoint) {
		logger.info("Sending request to add an appointment into db");
		Appointment newappoint = appointService.addAppoint(appoint);
		logger.info("Appoinment added successfully");
		return new ResponseEntity<>(newappoint, HttpStatus.CREATED);
	}
	
	@GetMapping("/appoint/getall/")
	ResponseEntity<List<Appointment>> getAllAppoint(){
		logger.info("Sending request to view all appointments");
		List<Appointment> allappoint = appointService.getAllAppoint();
		logger.info("All Appoinments viewed successfully");
		return new ResponseEntity<>(allappoint, HttpStatus.OK);
	}
	
	@GetMapping("/appoint/view/{appointId}")
	ResponseEntity<Appointment> viewAppoint(@PathVariable("appointId") int appointId) throws AppointNotFoundException {
		logger.info("Sending request to view an appointment in db");
		Appointment appoint = appointService.viewAppoint(appointId);
		logger.info("Viewed an appointment successfully");
		return new ResponseEntity<>(appoint, HttpStatus.OK);
		
	}
	

}
