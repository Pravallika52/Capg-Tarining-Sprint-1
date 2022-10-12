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

import com.example.demo.entity.Login;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.repository.ILoginRepository;

@ExtendWith(SpringExtension.class)
class LoginServiceMockitoTest {

	
	@InjectMocks
	LoginServiceImpl loginServ;
	
	@MockBean
	ILoginRepository loginRepo;
	
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
	void testGetLoginbyEmail() throws EmailNotFoundException {
		
		Login login=new Login();
		login.setLoginEmail("hema@gmail.com");
		login.setLoginPassword("hema123");
		
		Mockito.when(loginRepo.findByLoginEmail("hema@gmail.com")).thenReturn(Optional.of(login));
		
		Optional<Login> login1= loginRepo.findByLoginEmail(login.getLoginEmail());
		Login login2=login1.get();
		assertEquals("hema@gmail.com",login2.getLoginEmail());
		assertEquals("hema123",login2.getLoginPassword());	
	}	
}