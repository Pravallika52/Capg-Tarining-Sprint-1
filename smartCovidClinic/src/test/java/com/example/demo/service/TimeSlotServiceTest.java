package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.TimeSlot;
import com.example.demo.exception.SlotNotFoundException;


@SpringBootTest
class TimeSlotServiceTest{
	
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
		
		timeSlot.setTime("9PM");
		
		TimeSlot newTimeSlot = slotServ.addSlot(timeSlot);
		assertEquals("9PM", newTimeSlot.getTime());
		
		
	}
	
	@Test
	void deleteSlotByIdTest() throws SlotNotFoundException {
		TimeSlot slot = slotServ.deleteSlotById(24);
		assertEquals("8PM",slot.getTime());
	}
	
	@Test
	void getSlotTest() {
		List<TimeSlot> slots = slotServ.getAllSlot();
		TimeSlot time = slots.get(0);
		assertEquals("6PM", time.getTime());
	}

}