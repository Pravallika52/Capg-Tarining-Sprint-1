package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Ailment;
import com.example.demo.exception.AilmentExistsException;
import com.example.demo.exception.AilmentNotFoundException;
import com.example.demo.repository.IAilmentRepository;


@ExtendWith(SpringExtension.class)
class AilmentServiceMockitoTest {

	// @InjectMock - Creates instance of a class and injects mocks that are created
			// with @Mock

			@InjectMocks
			AilmentServiceImpl ailService;
			
			
			// @MockBean - Creates Mock of a class or interface
			@MockBean
			IAilmentRepository ailRepo;
			
			// Initialization of mock objects
			@BeforeEach
			void init() {
				MockitoAnnotations.openMocks(this);
			}
			
			@Test
			void testGetAilmentById() throws AilmentNotFoundException {
				
				Ailment ailment = new Ailment();
				ailment.setAilmentId(11);
				ailment.setAilment("joints");
				
				Mockito.when(ailRepo.findById(11)).thenReturn(Optional.of(ailment));
				
				Ailment ailment1 = ailService.getAilmentById(11);
				assertEquals(11, ailment1.getAilmentId());
				assertEquals("joints", ailment1.getAilment());
				
			}
			
			@Test
			void testAddAilment() throws AilmentExistsException {
				Ailment ailment = new Ailment();
				ailment.setAilmentId(11);
				ailment.setAilment("joints");
				
				Mockito.when(ailRepo.save(ailment)).thenReturn(ailment);
				Ailment ailment1= ailService.addAilment(ailment);
				assertEquals("joints", ailment1.getAilment());
			}

			@Test
			void testUpdateAilment() throws AilmentNotFoundException {
				Ailment ailment = new Ailment();
				ailment.setAilmentId(11);
				ailment.setAilment("joints");
				
				Ailment updatedAilment = new Ailment();
				updatedAilment.setAilmentId(11);
				updatedAilment.setAilment("joints");
				
				Mockito.when(ailRepo.findById(11)).thenReturn(Optional.of(ailment));
				Mockito.when(ailRepo.save(ailment)).thenReturn(updatedAilment);
				
				Ailment ailment2  =ailService.updateAilment(11, updatedAilment);
				assertEquals("joints", ailment2.getAilment());
			}
}