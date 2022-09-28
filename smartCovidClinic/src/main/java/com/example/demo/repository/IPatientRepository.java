package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patient;


@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
	
	
	Optional<Patient> findByPatientName( String patientName);

}