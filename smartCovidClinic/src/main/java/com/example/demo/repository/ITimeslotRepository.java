package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TimeSlot;

public interface ITimeslotRepository extends JpaRepository<TimeSlot, Integer> {

}
