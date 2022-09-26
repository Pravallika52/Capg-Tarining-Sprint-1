package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.Administrator;
import com.example.demo.entity.Patient;
import com.example.demo.exception.AdministratorFoundException;
import com.example.demo.exception.AdministratorNotFoundException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.service.IAdministratorService;
import com.example.demo.service.IPatientService;

@RestController
public class AdministratorController {
	
	@Autowired
	IAdministratorService admService;
	
	@Autowired
	IPatientService patService;
	
	@PostMapping("/admin/add")
	ResponseEntity<Administrator> addAdmin(@RequestBody Administrator admin) throws PasswordNotSameException, AdministratorFoundException {
		Administrator saveAdmin = admService.addAdmin(admin);
		return new ResponseEntity<>(saveAdmin,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/admin/delete/{adminId}")
	ResponseEntity<Administrator> deleteAdmin(@PathVariable("adminId") int adminId) throws AdministratorNotFoundException {
		Administrator delAdmin = admService.deleteAdmin(adminId);
		return new ResponseEntity<>(delAdmin, HttpStatus.OK);
		
	}
	
	@PutMapping("/admin/update/{adminId}")
	ResponseEntity<Administrator> updateAdmin(@PathVariable("adminId") int adminId, @RequestBody Administrator admin) throws AdministratorNotFoundException {
		Administrator updAdmin = admService.updateAdmin(adminId, admin);
		return new ResponseEntity<>(updAdmin, HttpStatus.OK);
	}
	
	@GetMapping("/admin/get/{adminId}")
	ResponseEntity<Administrator> getAdminById(@PathVariable("adminId") int adminId) throws AdministratorNotFoundException {
		Administrator getAdmin = admService.getAdminById(adminId);
		return new ResponseEntity<>(getAdmin, HttpStatus.OK);
	}
	
	@GetMapping("/admin/get/all")
	ResponseEntity<List<Administrator>> getAllAdmin() {
		List<Administrator> allAdmin = admService.getAllAdmin();
		return new ResponseEntity<>(allAdmin, HttpStatus.OK);
	}
	
	@GetMapping("/admin/getByEmail/{adminEmail}")
	ResponseEntity<Administrator> getAdminByEmail(@PathVariable("adminEmail") String adminEmail) throws AdministratorNotFoundException {
		Administrator getAdmin=admService.getAdminByEmail(adminEmail);
		return new ResponseEntity<>(getAdmin,HttpStatus.OK);
	}
	
	@GetMapping("/admin/getByName/{adminName}")
	ResponseEntity<Administrator> getAdminByName(@PathVariable("adminName") String adminName) throws AdministratorNotFoundException {
		Administrator getAdmin=admService.getAdminByName(adminName);
		return new ResponseEntity<>(getAdmin,HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/patient/delete/{pId}")
	ResponseEntity<Patient> deletePatientById(@PathVariable("pId") int pId) throws PatientNotFoundException {
		Patient deletedPatient = patService.deletePatientById(pId);
		return new ResponseEntity<>(deletedPatient,HttpStatus.OK);
	}
	
	@GetMapping("/admin/patient/getById/{pId}") 
	ResponseEntity<Patient> getPatientById(@PathVariable("pId") int pId) throws PatientNotFoundException  {
		Patient viewPatient = patService.getPatientById(pId);
		return new ResponseEntity<>(viewPatient,HttpStatus.OK);
	}
	
	@GetMapping("/admin/patient/getAll")
	ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> allPatients = patService.getAllPatients();
		return new ResponseEntity<>(allPatients,HttpStatus.OK);
		
	}
}
