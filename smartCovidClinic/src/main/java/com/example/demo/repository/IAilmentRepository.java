package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ailment;

@Repository
public interface IAilmentRepository extends JpaRepository<Ailment, Integer> {

}