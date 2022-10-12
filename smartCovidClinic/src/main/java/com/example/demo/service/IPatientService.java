package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PatientAppointmentDto;
import com.example.demo.dto.PatientInputDto;
import com.example.demo.dto.PatientOutputDto;
import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientExistsException;
import com.example.demo.exception.PatientNotFoundException;

public interface IPatientService {
	
	PatientOutputDto addPatient(PatientInputDto pnt) throws PatientExistsException;
	Patient deletePatientById(int pId) throws PatientNotFoundException;
	Patient updatePatient(int pId, Patient pnt) throws PatientNotFoundException;
	Patient getPatientById(int pId) throws PatientNotFoundException;
	List<Patient> getAllPatients();
	PatientOutputDto getPatientByIdDto(int patientId);
	Patient addPatientAppointment(int pId, PatientAppointmentDto pnt);
	Patient findByLoginEmail(String email);
//	PatientAppointmentDto updateAppointment(int pId,PatientAppointmentDto pnt);
}