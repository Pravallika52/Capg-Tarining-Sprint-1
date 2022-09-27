package com.example.demo.sevice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.TimeSlot;
import com.example.demo.exception.SlotNotFoundException;
import com.example.demo.service.TimeSlotServiceImpl;

@SpringBootTest
class TimeSlotService {
	
	@Autowired
	TimeSlotServiceImpl slotServ;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
	}

	@Test
	void addTimeSlot() throws SlotNotFoundException{
		TimeSlot timeSlot = new TimeSlot();
		
		timeSlot.setSlot("8PM");
		
		TimeSlot newTimeSlot = slotServ.addSlot(timeSlot);
		assertEquals("8PM", newTimeSlot.getSlot());
		
		
	}

}
