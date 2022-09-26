package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Appointment;


public interface IAppointmentService {
	
	Appointment addAppoint(Appointment appoint);
	List<Appointment> getAllAppoint();
	Appointment viewAppoint(int appointId);

}
