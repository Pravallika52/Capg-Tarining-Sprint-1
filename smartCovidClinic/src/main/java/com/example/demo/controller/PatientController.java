package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.example.demo.dto.PatientInputDto;
import com.example.demo.dto.PatientOutputDto;
import com.example.demo.exception.PatientExistsException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.repository.IPatientRepository;
import com.example.demo.service.IPatientService;

@RestController
public class PatientController {
	
	@Autowired
	IPatientService pntService;
	IPatientRepository pntRepo;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/patient/add")
	ResponseEntity<PatientOutputDto> newPatient(@Valid @RequestBody PatientInputDto pnt) throws PatientExistsException{
		logger.info("Sending Add request to database");
		PatientOutputDto newPnt = pntService.addPatient(pnt);
		logger.info("Added patient successfully");
		return new ResponseEntity<>(newPnt, HttpStatus.CREATED);
	}
	@DeleteMapping("/patient/delete/{pId}")
	ResponseEntity<PatientOutputDto> deletePatientById(@PathVariable("pId") int pId) throws PatientNotFoundException {
		PatientOutputDto pntDto = pntService.getPatientByIdDto(pId);
		pntService.deletePatientById(pId);
		return new ResponseEntity<>(pntDto, HttpStatus.OK);
	}
	@PutMapping("/patient/update/{pId}")
	ResponseEntity<PatientOutputDto> updatePatient(@PathVariable("pId") int pId, @RequestBody Patient pnt) throws PatientNotFoundException {
		Patient updatedPnt = pntService.updatePatient(pId, pnt);
		PatientOutputDto pntDto = pntService.getPatientByIdDto(updatedPnt.getPatientId());
		return new ResponseEntity<>(pntDto, HttpStatus.OK); 
	}
	@GetMapping("/patient/getAll")
	ResponseEntity<List<PatientOutputDto>> getAllPatients() {
		List<PatientOutputDto> pntDto= pntService.getAllPatients();
		return new ResponseEntity<>(pntDto, HttpStatus.OK);
	}
	@GetMapping("patient/get/{pId}")
	ResponseEntity<PatientOutputDto> getPatientByIdDto(@PathVariable("pId") int pId){
		PatientOutputDto pntDto = pntService.getPatientByIdDto(pId);
		return new ResponseEntity<>(pntDto,HttpStatus.OK);
	}

}