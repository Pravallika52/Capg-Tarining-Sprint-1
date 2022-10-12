package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.dto.PatientOutputDto;
import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientExistsException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.repository.IPatientRepository;

@ExtendWith(SpringExtension.class)
public class PatientServiceMockitoTest {
	
	@InjectMocks
	PatientServiceImpl pntService;
	
	@MockBean
	IPatientRepository pntRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetPatientById() throws PatientNotFoundException {
		Patient pnt = new Patient();
		pnt.setPatientId(7);
		pnt.setPatientName("Siri");
		Mockito.when(pntRepo.findById(7)).thenReturn(Optional.of(pnt));
		Patient pnt1 = pntService.getPatientById(7);
		assertEquals(7, pnt1.getPatientId());
		assertEquals("Siri", pnt1.getPatientName());
	}
	@Test
	void testGetPatientByIdDto() throws PatientNotFoundException {
		Patient pnt = new Patient();
		pnt.setPatientId(7);
		pnt.setPatientName("Siri");
		Mockito.when(pntRepo.findById(7)).thenReturn(Optional.of(pnt));
		PatientOutputDto pnt1 = pntService.getPatientByIdDto(7);
		assertEquals("Siri", pnt1.getPatientName());
	}
//	@Test
//	void testAddPatient() throws PatientNotFoundException, PatientExistsException{
//		Patient pnt = new Patient();
//		pnt.setPatientId(8);
//		pnt.setPatientName("Ravi");
//		Mockito.when(pntRepo.save(pnt)).thenReturn(pnt);
//		Patient pnt1= pntService.addPatient(pnt);
//		assertEquals("Ravi", pnt1.getPatientName());
//	}
	@Test
	void testUpdatePatient()throws PatientNotFoundException{
		Patient pnt = new Patient();
		pnt.setPatientId(6);
		pnt.setPatientName("Kavi");
		Patient updatedPnt = new Patient();
		updatedPnt.setPatientId(6);
		updatedPnt.setPatientName("Daniels");
		Mockito.when(pntRepo.findById(6)).thenReturn(Optional.of(updatedPnt));
		Mockito.when(pntRepo.save(pnt)).thenReturn(updatedPnt);
		Patient pnt1= pntService.updatePatient(6, updatedPnt);
		assertEquals("Daniels", pnt1.getPatientName());
		
	}
	@Test
	void testDeletePatientById() throws PatientNotFoundException {
		Patient pnt = new Patient();
		pnt.setPatientId(10);
		pnt.setPatientName("Alexa");
		Mockito.when(pntRepo.findById(10)).thenReturn(Optional.of(pnt));
		Patient pnt1 = pntService.deletePatientById(10);
		assertEquals(10, pnt1.getPatientId());
		assertEquals("Alexa", pnt1.getPatientName());
	}
}