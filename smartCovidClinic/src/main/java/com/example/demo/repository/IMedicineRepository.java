package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Medicine;

public interface IMedicineRepository extends JpaRepository<Medicine, Integer> {

}
