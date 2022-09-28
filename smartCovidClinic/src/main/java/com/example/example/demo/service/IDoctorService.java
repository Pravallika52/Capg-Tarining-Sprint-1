package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DoctorDto;
import com.example.demo.entity.Doctor;
import com.example.demo.exception.DoctorNotFoundException;

public interface IDoctorService {
	
	List<Doctor> getAllDoctors();
	Doctor getDocById(int docId) throws DoctorNotFoundException;
	Doctor addDoctor(Doctor doc);
	Doctor updateDoctorById(int docId,Doctor doc) throws DoctorNotFoundException;
	Doctor deleteDoctor(int docId) throws DoctorNotFoundException;
	List<DoctorDto> getAllDoctorDto();
	Doctor getDocByName(String doctorName) throws DoctorNotFoundException;

}
