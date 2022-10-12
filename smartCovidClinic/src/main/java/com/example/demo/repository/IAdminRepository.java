package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
	
	//Method to find the Administrator details using name
	Optional<Admin> findAdminByAdminName(String adminName);
	
	@Query(value="select * from admin inner join login on admin.admin_login_id=login.id where admin.admin_login_id= (select id from login where login_email=:email);", nativeQuery=true)
	Admin findByEmail(@Param("email")String email);

}
