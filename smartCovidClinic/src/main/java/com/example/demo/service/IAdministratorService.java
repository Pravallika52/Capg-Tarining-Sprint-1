package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Administrator;
import com.example.demo.exception.AdministratorFoundException;
import com.example.demo.exception.AdministratorNotFoundException;
import com.example.demo.exception.PasswordNotSameException;

public interface IAdministratorService {

	Administrator addAdmin(Administrator admin) throws PasswordNotSameException, AdministratorFoundException;
	Administrator deleteAdmin(int adminId) throws AdministratorNotFoundException;
	Administrator updateAdmin(int adminId, Administrator admin) throws AdministratorNotFoundException;
	Administrator getAdminById(int adminId) throws AdministratorNotFoundException;
	Administrator getAdminByEmail(String adminEmail) throws AdministratorNotFoundException;
	Administrator getAdminByName(String adminName) throws AdministratorNotFoundException;
	List<Administrator> getAllAdmin();
	

}
