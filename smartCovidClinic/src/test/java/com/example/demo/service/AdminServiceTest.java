package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.AdminInputDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminExistsException;
import com.example.demo.exception.AdminNotFoundException;
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
		AdminInputDto admin= new AdminInputDto();
		LoginDto login=new LoginDto();
		admin.setAdminName("abcd");
		login.setLoginEmail("abcd@gmail.com");
		login.setLoginPassword("abcd123");
		admin.setLoginDto(login);
		AdminDto newAdmin = adminServ.addAdmin(admin);
		assertEquals("abcd",newAdmin.getAdminName());
		assertEquals("abcd@gmail.com",newAdmin.getAdminEmail());
	}
	
	@Test
	void getAllAdminTest() {
		List<Admin> admins = adminServ.getAllAdmin();
		assertEquals(4,admins.size());
		Admin admin=admins.get(0);
		assertEquals("Ravi",admin.getAdminName());
	}
	
	@Test
	void getAllAdminDtoTest() {
		List<Admin> admins=adminServ.getAllAdmin();
		List<AdminDto> adminDtoList=new ArrayList<>();
		for(Admin admin:admins) {
			AdminDto adminDto=new AdminDto();
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminName(admin.getAdminName());
			adminDto.setAdminEmail(admin.getLogin().getLoginEmail());
			adminDtoList.add(adminDto);
		}
		assertEquals(admins.size(),adminDtoList.size());
		
	}
	
	@Test
	void deleteEmployeeTest() throws AdminNotFoundException {
		AdminDto admin=adminServ.removeAdminById(5);
		assertEquals("abc@gmail.com",admin.getAdminEmail());
	}

}
