package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IAppointmentService;


@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointService;
	
	
	

}
