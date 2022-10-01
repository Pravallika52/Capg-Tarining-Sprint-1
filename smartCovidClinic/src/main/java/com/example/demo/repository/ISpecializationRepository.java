package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Specialization;

@Repository
public interface ISpecializationRepository extends JpaRepository<Specialization, Integer> {

	Optional<Specialization> findSpecBySpecName(String specName);
	
	

}