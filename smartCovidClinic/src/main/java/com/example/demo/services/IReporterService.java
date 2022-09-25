package com.example.demo.services;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Reporter;

public interface IReporterService {
	
	Reporter addReporter(Reporter rep);
	Reporter checkDocAvailability(Doctor doc);
	
	

}
