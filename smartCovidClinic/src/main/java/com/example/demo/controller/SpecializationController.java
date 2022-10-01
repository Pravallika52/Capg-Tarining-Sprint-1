package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SpecOutputDto;
import com.example.demo.entity.Specialization;
import com.example.demo.exception.SpecExistsException;
import com.example.demo.exception.SpecNotFoundException;
import com.example.demo.service.ISpecializationService;

@RestController
public class SpecializationController {

	@Autowired
	ISpecializationService specService;
	
	private static Logger logger = LogManager.getLogger();

	@PostMapping("/spec/add")
	ResponseEntity<Specialization> addSpec(@Valid @RequestBody Specialization spec) throws SpecExistsException {
		Specialization newspec = specService.addSpec(spec);
		return new ResponseEntity<>(newspec, HttpStatus.CREATED);
	}

	@PutMapping("/spec/update/{specId}")
	ResponseEntity<Specialization> updateSpec(@PathVariable("specId")int specId,@RequestBody Specialization spec)throws SpecNotFoundException {
		Specialization updatedSpec = specService.updateSpec(specId, spec);
		return new ResponseEntity<>(updatedSpec, HttpStatus.OK);
	}

	@DeleteMapping("/spec/delete/{specId}")
	ResponseEntity<Specialization> deleteSpecById(@PathVariable("specId")int specId)throws SpecNotFoundException {
		Specialization deletedSpec = specService.deleteSpecById(specId);
		return new ResponseEntity<>(deletedSpec,HttpStatus.OK);
	}

	@GetMapping("/spec/getall/")
	ResponseEntity<List<Specialization>> getAllSpec(){
		List<Specialization> allspec = specService.getAllSpec();
		return new ResponseEntity<>(allspec, HttpStatus.OK);
	}
	
	@GetMapping("/spec/getall/dto")
    ResponseEntity<List<SpecOutputDto>> getAllSpecDto() {
		logger.info("Sending request to get all specializations available");
    	List<SpecOutputDto> specs = specService.getAllSpecDto();
		logger.info("Received all specializations from service");
    	return new ResponseEntity<>(specs, HttpStatus.OK);
    }

}