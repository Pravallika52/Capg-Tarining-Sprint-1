package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AdminDto;
import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminExistsException;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.exception.PasswordNotSameException;

public interface IAdminService {
	
	AdminDto addAdmin(Admin admin) throws AdminExistsException, PasswordNotSameException;
	Admin removeAdminById(int adminId) throws AdminNotFoundException;
	Admin updateAdmin(int adminId, Admin admin) throws AdminNotFoundException;
	List<Admin> getAllAdmin();
	List<AdminDto> getAllAdminDto();
	Admin findAdminById(int adminId) throws AdminNotFoundException;
//	Admin findAdminByEmail(String adminEmail) throws AdminNotFoundException;
	Admin findAdminByName(String adminName) throws AdminNotFoundException;

}
