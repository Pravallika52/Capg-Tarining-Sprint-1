package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PatientOutputDto;
import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientExistsException;
import com.example.demo.exception.PatientNotFoundException;

public interface IPatientService {
	
	Patient addPatient(Patient pnt) throws PatientExistsException;
	Patient deletePatientById(int pId) throws PatientNotFoundException;
	Patient updatePatient(int pId, Patient pnt) throws PatientNotFoundException;
	Patient getPatientById(int pId) throws PatientNotFoundException;
	List<PatientOutputDto> getAllPatients();
	PatientOutputDto getPatientByIdDto(int patientId);

}