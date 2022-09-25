package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer>{
	@Query(value="SELECT* from login l WHERE l.login_email= :loginEmail",nativeQuery=true)
	Optional<Login> findLoginByEmail(@Param("loginEmail") String loginEmail);

}
