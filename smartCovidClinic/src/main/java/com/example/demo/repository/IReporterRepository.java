package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Reporter;


public interface IReporterRepository extends JpaRepository<Reporter, Integer> {

}
