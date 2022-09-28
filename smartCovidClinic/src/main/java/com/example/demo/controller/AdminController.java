package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.example.demo.dto.PatientOutputDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.exception.AdminExistsException;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.exception.DoctorNotFoundException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.service.IAdminService;
import com.example.demo.service.IAppointmentService;
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
	
	@Autowired
	IAppointmentService appointServ;
	
	private static Logger logger = LogManager.getLogger();
	
	
	//Adding new Administrator to the Database
	@PostMapping("/admin/add")
	ResponseEntity<AdminDto> addAdmin(@RequestBody Admin admin) throws AdminExistsException, PasswordNotSameException {
		logger.info("Sending request to add a new Administrator");
		AdminDto newAdmin=adminServ.addAdmin(admin);
		logger.info("Added new Administrator to the Database");
		return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
		
	}
	
	//Deleting an existing Administrator from the Database
	@DeleteMapping("/admin/delete/{adminId}")
	ResponseEntity<Admin> removeAdminById(@PathVariable("adminId") int adminId) throws AdminNotFoundException{
		logger.info("Sending request to add a new Administrator");
		Admin deletedAdmin=adminServ.removeAdminById(adminId);
		logger.info("Removed an Administrator from the Database");
		return new ResponseEntity<>(deletedAdmin, HttpStatus.OK);
	}
	
	//Updating an existing Administrator in the Database
	@PutMapping("/admin/update/{adminId}")
	ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") int adminId, Admin admin) throws AdminNotFoundException{
		logger.info("Sending request to Update a Administrator");
		Admin updatedAdmin=adminServ.updateAdmin(adminId, admin);
		logger.info("Updated the Administrator in the Database");
		return new ResponseEntity<>(updatedAdmin,HttpStatus.OK);
	}
	
	//To View all the existing Administrators in the Database
	@GetMapping("/admin/getAllAdmin")
	ResponseEntity<List<Admin>> getAllAdmin(){
		logger.info("Sending request to get all Administrators");
		List<Admin> allAdmin=adminServ.getAllAdmin();
		logger.info("All the Administrators in the Database are presented");
		return new ResponseEntity<>(allAdmin, HttpStatus.OK);
	}
	
	@GetMapping("/admin/getAllAdminDto")
	ResponseEntity<List<AdminDto>> getAllAdminDto(){
		logger.info("Sending request to get all AdministratorDtos");
		List<AdminDto> admins=adminServ.getAllAdminDto();
		logger.info("All the AdministratorDtos in the Database are presented");
		return new ResponseEntity<>(admins,HttpStatus.OK);
	}
	
	@GetMapping("/admin/findById/{adminId}")
	ResponseEntity<Admin> getAdminById(@PathVariable("adminId") int adminId) throws AdminNotFoundException{
		logger.info("Sending request to get Administrator by ID");
		Admin admin=adminServ.findAdminById(adminId);
		logger.info("Presented the Administrator with the given ID");
		return new ResponseEntity<>(admin,HttpStatus.OK);
	}
	
//	@GetMapping("/admin/findByEmail/{adminEmail}")
//	ResponseEntity<Admin> getAdminByEmail(@PathVariable("adminEmail") String adminEmail) throws AdminNotFoundException{
//		logger.info("Sending request to get Administrator by Email");
//		Admin admin=adminServ.findAdminByEmail(adminEmail);
//		logger.info("Presented the Administrator with the given Email");
//		return new ResponseEntity<>(admin,HttpStatus.OK);
//	}

	@GetMapping("admin/getAllDoctors")
	ResponseEntity<List<Doctor>> getAllDoctors(){
		logger.info("Sending request to get List of all Doctors");
		List<Doctor> doctors = docServ.getAllDoctors();
		logger.info("All the Doctors in the Database are presented");
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}
	
	@GetMapping("admin/getDoctorById/{docId}")
	ResponseEntity<Doctor> getDocById(@PathVariable("docId") int docId) throws DoctorNotFoundException{
		logger.info("Sending request to get Doctor By ID");
		Doctor doctor=docServ.getDocById(docId);
		logger.info("Presented the Doctor with the given ID");
		return new ResponseEntity<>(doctor, HttpStatus.OK);
		
	}
	
	@PostMapping("admin/addDoctor")
	ResponseEntity<Doctor> addDoctor(Doctor doc) {
		logger.info("Sending request to add a Doctor");
		Doctor doctor = docServ.addDoctor(doc);
		logger.info("Added new Doctor to the Database");
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@PutMapping("admin/updateDoctor/{docId}")
	ResponseEntity<Doctor> updateDoctorById(@PathVariable("docId") int docId,@RequestBody Doctor doc) throws DoctorNotFoundException{
		logger.info("Sending request to update a Doctor");
		Doctor doctor= docServ.updateDoctorById(docId, doc);
		logger.info("Updated the Doctor in the Database");
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@DeleteMapping("admin/deleteDoctor")
	ResponseEntity<Doctor> deleteDoctor(int docId) throws DoctorNotFoundException{
		logger.info("Sending request to delete a Doctor");
		Doctor doctor = docServ.deleteDoctor(docId);
		logger.info("Removed a Doctor from the Database");
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	@GetMapping("/admin/getAllPatients")
	ResponseEntity<List<PatientOutputDto>> getAllPatients() {
		logger.info("Sending request to get List of all Patients");
		List<PatientOutputDto> patients= patientServ.getAllPatients();
		logger.info("All the Patients in the Database are presented");
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}
	
	@PutMapping("/admin/updateAppointment")
	ResponseEntity<Appointment> updateAppointment(@PathVariable("appointId") int appointId,@RequestBody Appointment appoint) throws AppointmentNotFoundException{
		logger.info("Sending request to update a Doctor");
		Appointment appoint1= appointServ.updateAppointment(appointId, appoint);
		logger.info("Updated the Doctor in the Database");
		return new ResponseEntity<>(appoint1, HttpStatus.OK);
	}
	

}
