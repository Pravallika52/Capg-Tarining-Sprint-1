package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Reporter;
import com.example.demo.service.IReporterService;



@RestController
public class ReporterController {
	
	@Autowired
	IReporterService repService;
	
	@PostMapping("/reporter/add")
	ResponseEntity<Reporter> addReporter(@RequestBody Reporter rep) {
		Reporter newRep = repService.addReporter(rep);
		return new ResponseEntity<>(newRep, HttpStatus.CREATED);

}
}