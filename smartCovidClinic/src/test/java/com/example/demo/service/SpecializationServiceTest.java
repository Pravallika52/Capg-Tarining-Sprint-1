package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.SpecOutputDto;
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
		spec.setSpecName("Orthopedic");
		Specialization newSpec= specService.addSpec(spec);
		assertEquals("Orthopedic", newSpec.getSpecName());
	}
	
	@Test
	void deleteSpecByIdTest() throws SpecNotFoundException {
		Specialization spec = specService.deleteSpecById(6);
		assertEquals("Cardialogist", spec.getSpecName());
	}
	
	@Test
	void getAllSpecTest() {
		List<Specialization> specs = specService.getAllSpec();
		assertEquals(7, specs.size());
		Specialization newspec = specs.get(0);
		assertEquals("Pulmonologist", newspec.getSpecName());
	}
	
	@Test
	void getAllSpecDtoTest() {
		List<Specialization> specs=specService.getAllSpec();
		List<SpecOutputDto> specDtoList=new ArrayList<>();
		for(Specialization spec:specs) {
			SpecOutputDto specDto=new SpecOutputDto();
			specDto.setSpecName(spec.getSpecName());
			specDtoList.add(specDto);
		}
		assertEquals(specs.size(),specDtoList.size());
	}
	

}