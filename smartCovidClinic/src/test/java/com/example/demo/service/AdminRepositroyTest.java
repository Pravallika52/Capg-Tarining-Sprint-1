package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Admin;
import com.example.demo.repository.IAdminRepository;

@SpringBootTest
class AdminRepositroyTest {
	
	@Autowired
	IAdminRepository adminRepo;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void findAdminByIdTest() {
		Optional<Admin> admin=adminRepo.findById(8);
		Admin admin1=admin.get();
		assertEquals("ssss",admin1.getAdminName());
	}
	
	@Test
	void getAllAdminTest() {
		List<Admin> admins = adminRepo.findAll();
		assertEquals(5,admins.size());
		Admin admin=admins.get(0);
		assertEquals("Ravi",admin.getAdminName());
	}

}
