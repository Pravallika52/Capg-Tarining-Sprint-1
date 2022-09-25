package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Reporter;
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
