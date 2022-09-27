package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Specialization;
import com.example.demo.exception.SpecExistsException;
import com.example.demo.exception.SpecNotFoundException;

@SpringBootTest
class SpecializationServiceTest {
	
	@Autowired
	ISpecializationService specService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll");
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
	void addSpecTest()throws SpecExistsException{
		Specialization spec = new Specialization();
		spec.setSpecName("Pulmonologist");
		Specialization newSpec= specService.addSpec(spec);
		assertEquals("Pulmonologist", newSpec.getSpecName());
	}
	
	@Test
	void deleteSpecByIdTest() throws SpecNotFoundException {
		Specialization spec = specService.deleteSpecById(15);
		assertEquals("Neurologist", spec.getSpecName());
	}
	
	@Test
	void updateSpecTest() throws SpecNotFoundException {
		Specialization spec = new Specialization();
		spec.setSpecName("Cardialogist");
		Specialization updatedSpec =specService.updateSpec(8, spec);
		assertEquals("Cardialogist", updatedSpec.getSpecName());
	}
	

}
