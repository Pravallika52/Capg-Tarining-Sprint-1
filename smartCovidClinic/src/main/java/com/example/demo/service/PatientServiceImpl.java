package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PatientInputDto;
import com.example.demo.dto.PatientOutputDto;
import com.example.demo.entity.Login;
import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientExistsException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.repository.ILoginRepository;
import com.example.demo.repository.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService{
	
	@Autowired
	IPatientRepository pntRepo;
	
	@Autowired
	ILoginRepository logRepo;
	
	private Logger logger = LogManager.getLogger();
	
	@Override
	public PatientOutputDto addPatient(PatientInputDto pnt)throws PatientExistsException {
		logger.info("Sending add Request to Repository ");	
		Optional<Login> loginOpt=logRepo.findByLoginEmail(pnt.getLogin().getLoginEmail());
		
		if(loginOpt.isPresent()) {
			throw new PatientExistsException("Patient already Exists" + pnt.getPatientName());
		}
		else {
		Patient newPnt = new Patient();
		newPnt.setPatientName(pnt.getPatientName());
		newPnt.setContact(pnt.getContact());
		newPnt.setAilment1(pnt.getAilment1());
		newPnt.setAilment2(pnt.getAilment2());
		newPnt.setAilment3(pnt.getAilment3());
		Login newLogin=new Login();
		newLogin.setLoginEmail(pnt.getLogin().getLoginEmail());
		newLogin.setLoginPassword(pnt.getLogin().getLoginPassword());
		newPnt.setLogin(newLogin);
		pntRepo.save(newPnt);
		PatientOutputDto pntDto= new PatientOutputDto();
		pntDto.setPatientName(newPnt.getPatientName());
		logger.info("Added Patient successfully");
		return pntDto;
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

//	@Override
//	public PatientAppointmentDto updateAppointment(int pId, PatientAppointmentDto pnt) {
//		Optional<Patient> pntOpt = pntRepo.findById(pId);
//		Patient newPnt = new Patient();
//		newPnt.setPatientName(pntOpt.get().getPatientName());
//		newPnt.setContact(pntOpt.get().getContact());
//		newPnt.setAilment1(pntOpt.get().getAilment1());
//		newPnt.setAilment2(pntOpt.get().getAilment2());
//		newPnt.setAilment3(pntOpt.get().getAilment3());
//		Login newLogin=new Login();
//		newLogin.setLoginEmail(pntOpt.get().getLogin().getLoginEmail());
//		newLogin.setLoginPassword(pntOpt.get().getLogin().getLoginPassword());
//		newPnt.setLogin(newLogin);
//		newPnt.setAppointmentDate(pnt.getAppointmentDate());
//		newPnt.setTimeSlot1(pnt.getTimeSlot1());
//		
//		pntRepo.save(newPnt);
//		return null;
//	}


	
	
	
	
	
	
	
	
}