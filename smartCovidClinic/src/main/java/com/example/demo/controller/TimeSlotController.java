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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TimeSlot;
import com.example.demo.exception.SlotNotFoundException;
import com.example.demo.service.ITimeSlotService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TimeSlotController {
	
	@Autowired
	ITimeSlotService timeService;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/slot/add")
	ResponseEntity<TimeSlot> addSlot(TimeSlot slot) {
		logger.info("Sending request to add a new TimeSlot");
		TimeSlot newslot = timeService.addSlot(slot);
		logger.info("Added new TimeSlot to the Database");
		return new ResponseEntity<>(newslot, HttpStatus.CREATED);
	}
	
	@PutMapping("/slot/update/{slotId}")
	ResponseEntity<TimeSlot> updateSlot(@PathVariable("slotId")int slotId,@RequestBody TimeSlot slot)throws SlotNotFoundException {
		logger.info("Sending request to add a new TimeSlot");
		TimeSlot updatedSlot = timeService.updateSlot(slotId, slot);
		logger.info("Updated the TimeSlot in the Database");
		return new ResponseEntity<>(updatedSlot, HttpStatus.OK);
	}
	
	@DeleteMapping("/slot/delete/{slotId}")
	ResponseEntity<TimeSlot> deleteSlotById(@PathVariable("slotId")int slotId)throws SlotNotFoundException  {
		logger.info("Sending request to add a new Timeslot");
		TimeSlot deleteSlot = timeService.deleteSlotById(slotId);
		logger.info("Removed a TimeSlot from the Database");
		return new ResponseEntity<>(deleteSlot, HttpStatus.OK);
	}
	
	@GetMapping("/slot/getall/")
	ResponseEntity<List<TimeSlot>> getAllSlot(){
		logger.info("Sending request to add a new Timeslot");
		List<TimeSlot> allslot = timeService.getAllSlot();
		logger.info("All the TimeSlot in the Database are presented");
		return new ResponseEntity<>(allslot, HttpStatus.OK);
}
	@GetMapping("/slot/get/{slotId}")
	ResponseEntity<TimeSlot> getSlotById(@PathVariable("slotId")int slotId)throws SlotNotFoundException  {
		logger.info("Sending request to add a new Timeslot");
		TimeSlot deleteSlot = timeService.deleteSlotById(slotId);
		logger.info("Presented the TimeSlot with the given ID");
		return new ResponseEntity<>(deleteSlot, HttpStatus.OK);
	}
	
}