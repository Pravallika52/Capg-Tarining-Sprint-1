package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Reporter;


public interface IReporterRepository extends JpaRepository<Reporter, Integer> {
	
	@Query(value="select * from reporter inner join login on reporter.id=login.id where reporter.id= (select id from login where login_email=:email);", nativeQuery=true)
	Reporter findByEmail(@Param("email")String email);


}