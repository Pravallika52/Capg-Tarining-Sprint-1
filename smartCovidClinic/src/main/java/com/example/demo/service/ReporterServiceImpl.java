package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Reporter;
import com.example.demo.repository.IReporterRepository;

@Service
public class ReporterServiceImpl implements IReporterService{
	
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

	@Override
	public List<Reporter> getAllReporters() {
		// TODO Auto-generated method stub
		List<Reporter> rep=repRepo.findAll();
		return rep;
	}

	@Override
	public String deleteReporter(int reporterId) {
		// TODO Auto-generated method stub
		repRepo.deleteById(reporterId);
		return "success";
	}

	@Override
	public Reporter findReporterByEmail(String email) {
		// TODO Auto-generated method stub
		Reporter reporter=repRepo.findByEmail(email);
		return reporter;
	}

}
