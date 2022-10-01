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

import com.example.demo.entity.TimeSlot;
import com.example.demo.exception.SlotNotFoundException;
import com.example.demo.service.ITimeSlotService;

@RestController
public class TimeSlotController {
	
	@Autowired
	ITimeSlotService timeService;
	
	@PostMapping("/slot/add")
	ResponseEntity<TimeSlot> addSlot(@Valid @RequestBody TimeSlot slot) {
		TimeSlot newslot = timeService.addSlot(slot);
		return new ResponseEntity<>(newslot, HttpStatus.CREATED);
	}
	
	@PutMapping("/slot/update/{slotId}")
	ResponseEntity<TimeSlot> updateSlot(@PathVariable("slotId")int slotId,@RequestBody TimeSlot slot)throws SlotNotFoundException {
		TimeSlot updatedSlot = timeService.updateSlot(slotId, slot);
		return new ResponseEntity<>(updatedSlot, HttpStatus.OK);
	}
	
	@DeleteMapping("/slot/delete/{slotId}")
	ResponseEntity<TimeSlot> deleteSlotById(@PathVariable("slotId")int slotId)throws SlotNotFoundException  {
		TimeSlot deleteSlot = timeService.deleteSlotById(slotId);
		return new ResponseEntity<>(deleteSlot, HttpStatus.OK);
	}
	
	@GetMapping("/slot/getall/")
	ResponseEntity<List<TimeSlot>> getAllSlot(){
		List<TimeSlot> allslot = timeService.getAllSlot();
		return new ResponseEntity<>(allslot, HttpStatus.OK);
}
	@GetMapping("/slot/get/{slotId}")
	ResponseEntity<TimeSlot> getSlotById(@PathVariable("slotId")int slotId)throws SlotNotFoundException  {
		TimeSlot getSlot = timeService.getSlotById(slotId);
		return new ResponseEntity<>(getSlot, HttpStatus.OK);
	}
	
}