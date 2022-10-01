package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.demo.dto.AilmentOutputDto;
import com.example.demo.entity.Ailment;
import com.example.demo.exception.AilmentExistsException;
import com.example.demo.exception.AilmentNotFoundException;
import com.example.demo.service.IAilmentService;

@RestController
public class AilmentController {
	
	@Autowired
	IAilmentService ailService;
	
	@PostMapping("/ailment/add")
	ResponseEntity<Ailment> newAilment(@Valid @RequestBody Ailment ailment)  throws AilmentExistsException {
	Ailment newAil = ailService.addAilment(ailment);
	return new ResponseEntity<>(newAil, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/ailment/delete/{ailmentId}")
	ResponseEntity<Ailment> deleteAilmentById(@PathVariable("ailmentId") int ailmentId) throws AilmentNotFoundException{
	Ailment ail = ailService.deleteAilmentById(ailmentId);
	return new ResponseEntity<>(ail, HttpStatus.OK);
	}

	@PutMapping("/ailment/update/{ailmentId}")
	ResponseEntity<Ailment> updateAilment(@PathVariable("ailmentId") int ailmentId, @RequestBody Ailment ailment) throws AilmentNotFoundException {
	Ailment updatedAilment = ailService.updateAilment(ailmentId, ailment);
	return new ResponseEntity<>(updatedAilment, HttpStatus.OK);
	}
	@GetMapping("/ailment/getAll")
	ResponseEntity<List<Ailment>> getAllPatients() {
	List<Ailment> ailments= ailService.getAllAilments();
	return new ResponseEntity<>(ailments, HttpStatus.OK);
	}
	
	@GetMapping("/ailment/getAllDto")
	ResponseEntity<List<AilmentOutputDto>> getAllAilmentsDto() {
		List<AilmentOutputDto> ailments= ailService.getAllAilmentsDto();
	return new ResponseEntity<>(ailments, HttpStatus.OK);
	}
	
	@GetMapping("/ailment/get/{ailmentId}")
	ResponseEntity<Ailment> getAilmentById(@PathVariable("ailmentId") int ailmentId) throws AilmentNotFoundException {
		Ailment ail = ailService.getAilmentById(ailmentId);
		return new ResponseEntity<>(ail, HttpStatus.OK);
	}
	
}