package com.example.demo.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Reporter;
import com.example.demo.exception.DoctorNotFoundException;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IReporterService;



@RestController
public class ReporterController {
	
	@Autowired
	IReporterService repService;
	
	@Autowired
	IDoctorService docServ;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/reporter/add")
	ResponseEntity<Reporter> addReporter(@Valid @RequestBody Reporter rep) {
		Reporter newRep = repService.addReporter(rep);
		return new ResponseEntity<>(newRep, HttpStatus.CREATED);

	}
	
	@PutMapping("reported/updateDoctor/{docId}")
	ResponseEntity<Doctor> updateDoctorById(@PathVariable("docId") int docId,@RequestBody Doctor doc) throws DoctorNotFoundException{
		logger.info("Sending request to update a Doctor");
		Doctor doctor= docServ.updateDoctorById(docId, doc);
		logger.info("Updated the Doctor in the Database");
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
}