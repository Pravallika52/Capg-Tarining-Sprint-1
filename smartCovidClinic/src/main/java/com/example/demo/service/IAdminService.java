package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.AdminInputDto;
import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminExistsException;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.exception.PasswordNotSameException;

public interface IAdminService {
	
	//Methods to be Implemented in the Implementation Class
	AdminDto addAdmin(AdminInputDto admin) throws AdminExistsException, PasswordNotSameException;
	AdminDto removeAdminById(int adminId) throws AdminNotFoundException;
	Admin updateAdmin(int adminId, Admin admin) throws AdminNotFoundException;
	List<Admin> getAllAdmin();
	List<AdminDto> getAllAdminDto();
	AdminDto findAdminById(int adminId) throws AdminNotFoundException;
	AdminDto findAdminByName(String adminName) throws AdminNotFoundException;
	Admin findfullAdminById(int adminId) throws AdminNotFoundException;
	Admin findByLoginEmail(String email);
}
