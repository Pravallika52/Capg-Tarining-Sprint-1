package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Reporter;

public interface IReporterService {
	
	Reporter addReporter(Reporter rep);
	Reporter checkDocAvailability(Doctor doc);
	
	

}
