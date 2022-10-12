package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.PatientOutputDto;
import com.example.demo.entity.Login;
import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientExistsException;
import com.example.demo.exception.PatientNotFoundException;

@SpringBootTest
public class PatientServiceTest {
	@Autowired
	PatientServiceImpl pntService;

//	@Test
//	void addPatientTest() throws PatientExistsException {
//		Patient pnt = new Patient();
//		Login login=new Login();
//		pnt.setPatientName("Kavi");
//		pnt.setContact(9786543210.0);
//		login.setLoginEmail("kavi@gmail.com");
//		login.setLoginPassword("kavi@123");
//		pnt.setLogin(login);
//		Patient newPnt= pntService.addPatient(pnt);
//		assertEquals("Kavi", newPnt.getPatientName());
//		assertEquals("kavi@gmail.com", newPnt.getLogin().getLoginEmail());
//		assertEquals(9786543210.0, newPnt.getContact());
//		assertEquals("kavi@123",newPnt.getLogin().getLoginPassword());
//	}
	@Test
	void deletePatientTest() throws PatientNotFoundException {
		Patient pnt = pntService.deletePatientById(28);
		assertEquals(9786543210.0, pnt.getContact());
	}
	@Test
	void getAllPatientsTest() {
		List<Patient> pnt = pntService.getAllPatients();
		assertEquals(10,pnt.size());
	}
	@Test
	void getPatientByIdTest() throws PatientNotFoundException {
		Patient pnt = pntService.getPatientById(31);
		assertEquals("Samantha", pnt.getPatientName());
		assertEquals("Sam@123",pnt.getLogin().getLoginPassword());
	}
	@Test
	void getPatientByIdDto()throws PatientNotFoundException{
		PatientOutputDto pntDto = pntService.getPatientByIdDto(25);
		assertEquals("ChrisJ",pntDto.getPatientName());
		
	}
}