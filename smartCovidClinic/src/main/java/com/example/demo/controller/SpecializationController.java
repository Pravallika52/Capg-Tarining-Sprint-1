package com.example.demo.controller;

import java.util.List;

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
	ResponseEntity<Specialization> addSpec(Specialization spec) throws SpecExistsException{
		logger.info("Sending request to add spec into db");
		Specialization newspec = specService.addSpec(spec);
		logger.info("Spec added successfully");
		return new ResponseEntity<>(newspec, HttpStatus.CREATED);
	}

	@PutMapping("/spec/update/{specId}")
	ResponseEntity<Specialization> updateSpec(@PathVariable("specId")int specId,@RequestBody Specialization spec)throws SpecNotFoundException {
		logger.info("Sending request to update spec into db");
		Specialization updatedSpec = specService.updateSpec(specId, spec);
		logger.info("Spec updated successfully");
		return new ResponseEntity<>(updatedSpec, HttpStatus.OK);
	}

	@DeleteMapping("/spec/delete/{specId}")
	ResponseEntity<Specialization> deleteSpecById(@PathVariable("specId")int specId)throws SpecNotFoundException {
		logger.info("Sending request to delete spec in database");
		Specialization deletedSpec = specService.deleteSpecById(specId);
		logger.info("Spec deleted successfully");
		return new ResponseEntity<>(deletedSpec,HttpStatus.OK);
	}

	@GetMapping("/spec/getall/")
	ResponseEntity<List<Specialization>> getAllSpec(){
		logger.info("Sending request to get all spec details");
		List<Specialization> allspec = specService.getAllSpec();
		logger.info("Received all spec details from service");
		return new ResponseEntity<>(allspec, HttpStatus.OK);
	}
	
	@GetMapping("/spec/getall/dto")
    ResponseEntity<List<SpecOutputDto>> getAllSpecDto() {
		logger.info("Sending request to get all specializations available");
    	List<SpecOutputDto> specs = specService.getAllSpecDto();
		logger.info("Received all specializations from service");
    	return new ResponseEntity<>(specs, HttpStatus.OK);
    }
	
	@GetMapping("/spec/getById/{specId}")
	ResponseEntity<Specialization> getSpec(@PathVariable("specId")int specId)throws SpecNotFoundException{
		logger.info("Sending request to get specialization by id");
		Specialization spec = specService.getSpec(specId);
		logger.info("Received specialization by id successfully");
		return new ResponseEntity<>(spec, HttpStatus.OK);
	}

}
