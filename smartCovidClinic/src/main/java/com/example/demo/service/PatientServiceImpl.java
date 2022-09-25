package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.repository.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {
	
	@Autowired
	IPatientRepository pntRepo;
	
	@Override
	public Patient addPatient(Patient pnt) {
		Patient newPnt = pntRepo.save(pnt);
		return newPnt;
	}

	@Override
	public Patient updatePatient(int pId, Patient patient) throws PatientNotFoundException {
		Optional<Patient> pntOpt = pntRepo.findById(pId);
		if (pntOpt.isPresent()) {
			Patient pnt = pntOpt.get();
		    return pntRepo.save(patient);
		} else {
			throw new PatientNotFoundException("Employee not found with given id: " + pId);
		}
	}

	@Override
	public Patient deletePatientById(int pId) throws PatientNotFoundException {
		Optional<Patient> pntOpt = pntRepo.findById(pId);
		if (pntOpt.isPresent()) {
			Patient pnt = pntOpt.get();
			pntRepo.deleteById(pId);
			return pnt;
		} else {
			throw new PatientNotFoundException("Patient not found with given id: " + pId);
		}

	}


	@Override
	public Patient getPatientById(int pId) throws PatientNotFoundException {
		Optional<Patient> pntOpt = pntRepo.findById(pId);
		if (pntOpt.isPresent()) {
			Patient pnt = pntOpt.get();
			return pnt;
		} else {
			throw new PatientNotFoundException("Patient not found with given id: " + pId);
		}
	}



	@Override
	public List<Patient> getAllPatients() {
		List<Patient> pnt = pntRepo.findAll();
		return pnt;
	}
	
}