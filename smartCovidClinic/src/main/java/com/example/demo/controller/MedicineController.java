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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Medicine;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.service.IMedicineService;

@RestController
public class MedicineController {
	
	@Autowired
	IMedicineService medServ;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/medicine/add")
	ResponseEntity<Medicine> addMedicine(@Valid @RequestBody Medicine medicine) {
		//Sending Information to console using Logger
		logger.info("Sending request to add a new Medicine");
		Medicine newMed=medServ.addMedicine(medicine);
		logger.info("Added new Medicine to the Database");
		return new ResponseEntity<>(newMed, HttpStatus.CREATED);
		
	}
	
	//Deleting an existing Medicine from the Database
	@DeleteMapping("/medicine/delete/{medicineId}")
	ResponseEntity<Medicine> removeMedicineById(@PathVariable("medicineId") int medicineId) throws AdminNotFoundException{
		//Sending Information to console using Logger
		logger.info("Sending request to delete a Medicine");
		Medicine deletedMedicine=medServ.removeMedicin(medicineId);
		logger.info("Removed an Medicine from the Database");
		return new ResponseEntity<>(deletedMedicine, HttpStatus.OK);
	}
	
	//To View all the existing Medicine in the Database
		@GetMapping("/medicine/getAllMed")
		ResponseEntity<List<Medicine>> getAllMedicine(){
			//Sending Information to console using Logger
			logger.info("Sending request to get all Medicines");
			List<Medicine> allMedicine=medServ.getAllMedicine();
			logger.info("All the Medicines in the Database are presented");
			return new ResponseEntity<>(allMedicine, HttpStatus.OK);
		}

}
