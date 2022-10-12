package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Patient;


@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
	
	
	Optional<Patient> findByPatientName( String patientName);
	
	@Query(value="select * from patient inner join login on patient.patient_login_id=login.id where patient.patient_login_id= (select id from login where login_email=:email);", nativeQuery=true)
	Patient findByEmail(@Param("email")String email);

}