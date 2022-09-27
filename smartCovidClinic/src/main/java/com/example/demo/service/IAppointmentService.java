package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Appointment;
import com.example.demo.exception.AppointNotFoundException;


public interface IAppointmentService {
	
	Appointment addAppoint(Appointment appoint);
	List<Appointment> getAllAppoint();
	Appointment viewAppoint(int appointId)throws AppointNotFoundException;

}
