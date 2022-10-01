package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	
	//Method to find the Administrator details using name
	Optional<Admin> findAdminByAdminName(String adminName);

}
