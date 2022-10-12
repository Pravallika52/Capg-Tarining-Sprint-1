package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.dto.AdminDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Login;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.repository.IAdminRepository;

@ExtendWith(SpringExtension.class)
class AdminServiceMockitoTest {

	
	@InjectMocks
	AdminServiceImpl adminServ;
	
	@MockBean
	IAdminRepository adminRepo;
	
	@BeforeEach
	void init(){
		MockitoAnnotations.openMocks(this);
	}
	
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
	void testGetAdminById() throws AdminNotFoundException {
		
		Admin admin=new Admin();
		Login login=new Login();
		admin.setAdminId(20);
		admin.setAdminName("Hema");
		login.setLoginEmail("hema@gmail.com");
		login.setLoginPassword("hema123");
		admin.setLogin(login);
		
		Mockito.when(adminRepo.findById(20)).thenReturn(Optional.of(admin));
		
		AdminDto admin1= adminServ.findAdminById(20);
		assertEquals(20,admin1.getAdminId());
		assertEquals("Hema",admin1.getAdminName());
		assertEquals("hema@gmail.com",admin1.getAdminEmail());

		
	}
	
//	@Test
//	void testAddAdmin() throws AdminExistsException, PasswordNotSameException {
//		AdminInputDto admin = new AdminInputDto();
//		LoginDto login=new LoginDto();
//		admin.setAdminName("Hema");
//		login.setLoginEmail("hema@gmail.com");
//		login.setLoginPassword("hema123");
//		admin.setLoginDto(login);
//		
//		Mockito.when(adminRepo.save(admin)).thenReturn(admin);
//		AdminDto admin1= adminServ.addAdmin(admin);
//		assertEquals("Hema", admin1.getAdminName());
//	}
	
	@Test
	void testDeleteAdmin() throws AdminNotFoundException {
		Admin admin = new Admin();
		Login login=new Login();
		admin.setAdminId(20);
		admin.setAdminName("Hema");
		login.setLoginEmail("hema@gmail.com");
		login.setLoginPassword("hema123");
		admin.setLogin(login);
		
		Mockito.when(adminRepo.findById(20)).thenReturn(Optional.of(admin));
		//Mockito.when(empRepo.deleteById(10)).
		AdminDto admin1= adminServ.removeAdminById(20);
		assertEquals(20, admin1.getAdminId());
		
	}

}
