package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.TimeSlot;
import com.example.demo.exception.SlotNotFoundException;
import com.example.demo.repository.ITimeSlotRepository;

@ExtendWith(SpringExtension.class)
class TimeSlotMockitoTest {
	
	@InjectMocks
	TimeSlotServiceImpl timeServ;
	
	@MockBean
	ITimeSlotRepository timeRepo;

	@BeforeEach
	void init(){
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void addTimeSlot() throws SlotNotFoundException{
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setTime("6PM");
		
		Mockito.when(timeRepo.save(timeSlot)).thenReturn(timeSlot);
		TimeSlot newTimeSlot = timeServ.addSlot(timeSlot);
		assertEquals("6PM", newTimeSlot.getTime());
		
		
	}
	


}