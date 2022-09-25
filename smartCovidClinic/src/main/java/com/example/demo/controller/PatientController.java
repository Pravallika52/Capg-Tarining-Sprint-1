package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.service.IPatientService;

@RestController
public class PatientController {
	
	@Autowired
	IPatientService pntService;
	
	@PostMapping("/patient/add")
	ResponseEntity<Patient> newPatient(@RequestBody Patient pnt){
		Patient newPnt = pntService.addPatient(pnt);
		return new ResponseEntity<>(newPnt, HttpStatus.CREATED);
	}
	@DeleteMapping("/patient/delete/{pId}")
	ResponseEntity<Patient> deletePatientById(@PathVariable("pId") int pId) throws PatientNotFoundException {
		Patient pnt = pntService.deletePatientById(pId);
		return new ResponseEntity<>(pnt, HttpStatus.OK); //200 ok
	}
	@PutMapping("/patient/update/{pId}")
	ResponseEntity<Patient> updatePatient(@PathVariable("pId") int pId, @RequestBody Patient pnt) throws PatientNotFoundException {
		Patient updatedpnt = pntService.updatePatient(pId, pnt);
		return new ResponseEntity<>(updatedpnt, HttpStatus.OK); // 200 Ok
	}
	@GetMapping("/patient/get/{pId}")
	ResponseEntity<Patient> getPatientById(@PathVariable("pId") int pId) throws PatientNotFoundException {
		Patient pnt = pntService.getPatientById(pId);
		return new ResponseEntity<>(pnt, HttpStatus.OK);
	}
	@GetMapping("/patient/getAll")
	ResponseEntity<List<Patient>> getAllPatients() {
	List<Patient> patients= pntService.getAllPatients();
	return new ResponseEntity<>(patients, HttpStatus.OK);
	}

}