package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Reporter;

public interface IReporterService {
	
	Reporter addReporter(Reporter rep);
	Reporter checkDocAvailability(Doctor doc);
	List<Reporter> getAllReporters();
	String deleteReporter(int reporterId);
	Reporter findReporterByEmail(String email);
}
