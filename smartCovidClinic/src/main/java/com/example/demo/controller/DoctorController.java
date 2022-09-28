package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.exception.DoctorNotFoundException;
import com.example.demo.service.IAppointmentService;
import com.example.demo.service.IDoctorService;

@RestController
public class DoctorController {

	@Autowired
	IDoctorService docServ;
	
	@Autowired
	IAppointmentService appointServ;
	
	private static Logger logger = LogManager.getLogger();
	
	@GetMapping("doctor/getAllAppointments")
	ResponseEntity<List<Appointment>> getAllAppointment(){
		List<Appointment> appointments=appointServ.getAllAppoint();
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}
	
	@GetMapping("doctor/getDoctorByName/{name}")
	ResponseEntity<Doctor> getDocByName(@PathVariable("name") String name) throws DoctorNotFoundException {
		logger.info("Sending request to get doctor by name");
		Doctor doctor=docServ.getDocByName(name);
		logger.info("Successfully get a doctor of given name from database.");
		return new ResponseEntity<>(doctor,HttpStatus.OK);
	}
}
