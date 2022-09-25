package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminExistsException;
import com.example.demo.exception.PasswordNotSameException;

@SpringBootTest
class AdminServiceTest {
	
	@Autowired
	AdminServiceImpl adminServ;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
	}

	@Test
	void addAdminTest() throws AdminExistsException, PasswordNotSameException{
		Admin admin= new Admin();
		admin.setAdminName("Raghav");
		admin.setAdminEmail("raghav@gmail.com");
		admin.setAdminPassword("raghav123");
		admin.setAdminConfirmPassword("raghav123");
		Admin newAdmin = adminServ.addAdmin(admin);
		assertEquals("Raghav",newAdmin.getAdminName());
		assertEquals("raghav@gmail.com",newAdmin.getAdminEmail());
	}

}
