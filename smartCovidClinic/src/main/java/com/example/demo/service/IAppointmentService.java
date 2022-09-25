package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Appointment;


public interface IAppointmentService {
	
	List<Appointment> viewAppointment(int appointId);

}
