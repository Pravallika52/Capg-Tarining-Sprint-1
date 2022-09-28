package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointment;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.repository.IAppointmentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	
	@Autowired
	IAppointmentRepository appointRepo;

	@Override
	public Appointment addAppoint(Appointment appoint) {
		Appointment newappoint = appointRepo.save(appoint);
		return newappoint;
	}

	@Override
	public List<Appointment> getAllAppoint() {
		List<Appointment> allappoint = appointRepo.findAll();
		return allappoint;
	}

	@Override
	public Appointment viewAppoint(int appointId) {
		Optional<Appointment> appointOpt = appointRepo.findById(appointId);
		Appointment appoint = appointOpt.get();
		return appoint;

	}

	@Override
	public Appointment updateAppointment(int appointId, Appointment appoint) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Appointment> appointOpt=appointRepo.findById(appointId);
		if(appointOpt.isPresent()) {
			Appointment updateAppoint=appointOpt.get();
			appointRepo.save(appoint);
			return updateAppoint;
		}
		else {
			throw new AppointmentNotFoundException("Appointment not Found with the given ID: "+appointId);
		}
	}

}
