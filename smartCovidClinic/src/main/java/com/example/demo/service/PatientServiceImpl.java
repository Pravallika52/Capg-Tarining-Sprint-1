package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PatientOutputDto;
import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientExistsException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.repository.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {
	
	@Autowired
	IPatientRepository pntRepo;
	
	private Logger logger = LogManager.getLogger();
	
	@Override
	public Patient addPatient(Patient pnt)throws PatientExistsException {
		logger.info("Sending add Request to Repository ");	
		Optional<Patient> pnt1 = pntRepo.findByPatientName(pnt.getPatientName());
		if(pnt1.isPresent()) {
			throw new PatientExistsException("Patient already Exists" + pnt.getPatientName());
		}
		else {
		Patient newPnt = pntRepo.save(pnt);
		logger.info("Added Patient successfully");
		return newPnt;
		}
	}

	@Override
	public Patient updatePatient(int pId, Patient patient) throws PatientNotFoundException {
		logger.info("Sending update Request to repository");
		Optional<Patient> pntOpt = pntRepo.findById(pId);
		if (pntOpt.isPresent()) {
			Patient pnt = pntOpt.get();
			pntRepo.save(patient);
			logger.info("Patient updated successfully");
		    return pnt;
		} else {
			throw new PatientNotFoundException("Employee not found with given id: " + pId);
		}
	}

	@Override
	public Patient deletePatientById(int pId) throws PatientNotFoundException {
		logger.info("Sending delete Request to repository");
		Optional<Patient> pntOpt = pntRepo.findById(pId);
		if (pntOpt.isPresent()) {
			Patient pnt = pntOpt.get();
			pntRepo.deleteById(pId);
			logger.info("Deleted a patient Successfully");
			return pnt;
		} else {
			throw new PatientNotFoundException("Patient not found with given id: " + pId);
		}

	}

	@Override
	public Patient getPatientById(int pId) throws PatientNotFoundException {
		logger.info("View request sent to Repository");
		Optional<Patient> pntOpt = pntRepo.findById(pId);
		if (pntOpt.isPresent()) {
			Patient pnt = pntOpt.get();
			logger.info("Patient viewed successfully");
			return pnt;
		} else {
			throw new PatientNotFoundException("Patient not found with given id: " + pId);
		}
	}

	@Override
	public List<PatientOutputDto> getAllPatients() {
		logger.info("View All Patients Request Sent to Repository");
		List<Patient> pnt = pntRepo.findAll();
		List<PatientOutputDto> pntDtoList= new ArrayList<>();
		for(Patient p:pnt) {
			PatientOutputDto pntDto = new PatientOutputDto();
			  pntDto.setPatientName(p.getPatientName());
			  
			  // add dto obj into the dto List.
			  pntDtoList.add(pntDto);
		}
		logger.info("Viewed successfully");
		return pntDtoList;
		
		
	}

	@Override
	public PatientOutputDto getPatientByIdDto(int pId) {
		logger.info("View request sent to Repository");
		Optional<Patient> pnt = pntRepo.findById(pId);
		Patient pnt1 = pnt.get();
		PatientOutputDto pntDto = new PatientOutputDto();
		pntDto.setPatientName(pnt1.getPatientName());
		logger.info("Viewed successfully");
		return pntDto;
	}


	
	
	
	
	
	
	
	
}