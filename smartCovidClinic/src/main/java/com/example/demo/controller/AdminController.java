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

import com.example.demo.dto.AdminDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.exception.AdminExistsException;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.exception.DoctorNotFoundException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IPatientService;

@RestController
public class AdminController {
	
	@Autowired
	IAdminService adminServ;
	
	@Autowired
	IPatientService patientServ;
	
	@Autowired
	IDoctorService docServ;
	
	
	//Adding new Administrator to the Database
	@PostMapping("/admin/add")
	ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminExistsException, PasswordNotSameException {
//		logger.info("Sending request to add a new Administrator");
		Admin newAdmin=adminServ.addAdmin(admin);
//		logger.info("Added new Administrator to the Database");
		return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
		
	}
	
	//Deleting an existing Administrator from the Database
	@DeleteMapping("/admin/delete/{adminId}")
	ResponseEntity<Admin> removeAdminById(@PathVariable("adminId") int adminId) throws AdminNotFoundException{
		Admin deletedAdmin=adminServ.removeAdminById(adminId);
		return new ResponseEntity<>(deletedAdmin, HttpStatus.OK);
	}
	
	//Updating an existing Administrator in the Database
	@PutMapping("/admin/update/{adminId}")
	ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") int adminId, Admin admin) throws AdminNotFoundException{
		Admin updatedAdmin=adminServ.updateAdmin(adminId, admin);
		return new ResponseEntity<>(updatedAdmin,HttpStatus.OK);
	}
	
	//To View all the existing Administrators in the Database
	@GetMapping("/admin/getAllAdmin")
	ResponseEntity<List<Admin>> getAllAdmin(){
		List<Admin> allAdmin=adminServ.getAllAdmin();
		return new ResponseEntity<>(allAdmin, HttpStatus.OK);
	}
	
	@GetMapping("/admin/getAllAdminDto")
	ResponseEntity<List<AdminDto>> getAllAdminDto(){
		List<AdminDto> admins=adminServ.getAllAdminDto();
		return new ResponseEntity<>(admins,HttpStatus.OK);
	}
	
	@GetMapping("/admin/findById/{adminId}")
	ResponseEntity<Admin> getAdminById(@PathVariable("adminId") int adminId) throws AdminNotFoundException{
		Admin admin=adminServ.findAdminById(adminId);
		return new ResponseEntity<>(admin,HttpStatus.OK);
	}
	
	@GetMapping("/admin/findByEmail/{adminEmail}")
	ResponseEntity<Admin> getAdminByEmail(@PathVariable("adminEmail") String adminEmail) throws AdminNotFoundException{
		Admin admin=adminServ.findAdminByEmail(adminEmail);
		return new ResponseEntity<>(admin,HttpStatus.OK);
	}

	@GetMapping("admin/getAllDoctors")
	ResponseEntity<List<Doctor>> getAllDoctors(){
		List<Doctor> doctors = docServ.getAllDoctors();
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}
	
	@GetMapping("admin/getDoctorById/{docId}")
	ResponseEntity<Doctor> getDocById(@PathVariable("docId") int docId) throws DoctorNotFoundException{
		Doctor doctor=docServ.getDocById(docId);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
		
	}
	
	@PostMapping("admin/addDoctor")
	ResponseEntity<Doctor> addDoctor(Doctor doc) {
		Doctor doctor = docServ.addDoctor(doc);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@PutMapping("admin/updateDoctor")
	ResponseEntity<Doctor> updateDoctorById(int docId,Doctor doc) throws DoctorNotFoundException{
		Doctor doctor= docServ.updateDoctorById(docId, doc);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@DeleteMapping("admin/deleteDoctor")
	ResponseEntity<Doctor> deleteDoctor(int docId) throws DoctorNotFoundException{
		Doctor doctor = docServ.deleteDoctor(docId);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@GetMapping("/admin/getAllPatients")
	ResponseEntity<List<Patient>> getAllPatients() {
	List<Patient> patients= patientServ.getAllPatients();
	return new ResponseEntity<>(patients, HttpStatus.OK);
	}

}
