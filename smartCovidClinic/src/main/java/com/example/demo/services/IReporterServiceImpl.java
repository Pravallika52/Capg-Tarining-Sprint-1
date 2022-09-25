package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Reporter;
import com.example.demo.repository.IReporterRepository;

@Service
public class IReporterServiceImpl implements IReporterService {
	
	@Autowired
	IReporterRepository repRepo;
	

	@Override
	public Reporter addReporter(Reporter rep) {
		Reporter newrep = repRepo.save(rep);
		return newrep;
	}

	@Override
	public Reporter checkDocAvailability(Doctor doc) {
		// TODO Auto-generated method stub
		return null;
	}

}
