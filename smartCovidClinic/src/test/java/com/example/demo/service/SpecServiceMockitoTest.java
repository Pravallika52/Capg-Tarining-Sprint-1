package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Specialization;
import com.example.demo.exception.SpecExistsException;
import com.example.demo.exception.SpecNotFoundException;
import com.example.demo.repository.ISpecializationRepository;

@ExtendWith(SpringExtension.class)
class SpecServiceMockitoTest {
	
	@InjectMocks
	SpecializationServiceImpl specService;
	
	@MockBean
	ISpecializationRepository specRepo;
	
	Specialization spec = new Specialization();
	
	@BeforeEach
	void init(){
		MockitoAnnotations.openMocks(this);
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
//		spec.setSpecilizationId(20);
//		spec.setSpecName("Pulmonologist");
	}

	@AfterEach
	void tearDown() throws Exception {
//		specService.deleteSpecById(20);
	}

	@Test
	void testAddSpec()throws SpecExistsException {
		
		spec.setSpecilizationId(20);
		spec.setSpecName("Pulmonologist");
		
		Mockito.when(specRepo.save(spec)).thenReturn(spec);
		Specialization spec1= specService.addSpec(spec);
		assertEquals("Pulmonologist", spec1.getSpecName());
	}
	
	@Test
	void testUpdateSpec() throws SpecNotFoundException {
		Specialization spec = new Specialization();
		spec.setSpecilizationId(30);
		spec.setSpecName("Physiotherapist");
		
		Specialization updatedspec = new Specialization();
		updatedspec.setSpecilizationId(30);
		updatedspec.setSpecName("Gynacologist");
		
		Mockito.when(specRepo.findById(30)).thenReturn(Optional.of(updatedspec));
		Mockito.when(specRepo.save(spec)).thenReturn(updatedspec);
		
		Specialization spec2  =specService.updateSpec(30, updatedspec);
		assertEquals("Gynacologist", spec2.getSpecName());
	}
	
	@Test
	void testDeleteSpec() throws SpecNotFoundException {
		
		spec.setSpecilizationId(20);
		spec.setSpecName("Pulmonologist");
		
		Mockito.when(specRepo.findById(20)).thenReturn(Optional.of(spec));
		Specialization deletespec= specService.deleteSpecById(20);
		assertEquals(20, deletespec.getSpecilizationId());
		
	}
}