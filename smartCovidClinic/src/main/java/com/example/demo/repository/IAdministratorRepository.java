package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Administrator;

@Repository
public interface IAdministratorRepository extends JpaRepository<Administrator, Integer> {
	
	@Query(value="SELECT * from admin a WHERE a.admin_email= :adminEmail",nativeQuery=true)
	Optional<Administrator> getAdminByEmail(@Param("adminEmail") String adminEmail);
	
	@Query(value="SELECT * from admin a WHERE a.admin_name= :adminName",nativeQuery=true)
	Optional<Administrator> getAdminByName(@Param("adminName") String adminName);

}
