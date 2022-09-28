package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	
//	@Query(value="SELECT * from admin a WHERE a.admin_email= :adminEmail",nativeQuery=true)
//	Optional<Admin> findAdminByEmail(@Param("adminEmail") String adminEmail);
//	
//	Optional<Admin> findAdminByAdminEmail(String adminEmail);
	
	Optional<Admin> findAdminByAdminName(String adminName);

}
