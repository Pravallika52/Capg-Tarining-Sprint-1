package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ailment;

@Repository
public interface IAilmentRepository extends JpaRepository<Ailment, Integer> {
	Optional<Ailment> findByAilment(String ailment);
	
}