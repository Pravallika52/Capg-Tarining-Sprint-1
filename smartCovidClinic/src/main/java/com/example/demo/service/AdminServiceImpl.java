package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.AdminInputDto;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Login;
import com.example.demo.exception.AdminExistsException;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.repository.IAdminRepository;
import com.example.demo.repository.ILoginRepository;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	IAdminRepository adminRepo;
	
	@Autowired
	ILoginRepository logRepo;
	
	@Override
	public AdminDto addAdmin(AdminInputDto admin) throws AdminExistsException, PasswordNotSameException{
		//Searching the database for an Administrator with the name
		Optional<Login> loginOpt=logRepo.findByLoginEmail(admin.getLoginDto().getLoginEmail());
		//If there is an Administrator with the given details isPresent method gives out true
		if(loginOpt.isPresent()) {
			throw new AdminExistsException("Admin Already Exists with the given Email: "+admin.getLoginDto().getLoginEmail());
		}
		Admin newAdmin=new Admin();
		newAdmin.setAdminName(admin.getAdminName());
		Login newLogin=new Login();
		newLogin.setLoginEmail(admin.getLoginDto().getLoginEmail());
		newLogin.setLoginPassword(admin.getLoginDto().getLoginPassword());
		newAdmin.setLogin(newLogin);
//		Admin newAdmin=adminRepo.save(admin);
		AdminDto adminDto=new AdminDto();
		adminDto.setAdminId(newAdmin.getAdminId());
		adminDto.setAdminName(newAdmin.getAdminName());
		adminDto.setAdminEmail(newAdmin.getLogin().getLoginEmail());
		
		return adminDto;
	}

	@Override
	public AdminDto removeAdminById(int adminId) throws AdminNotFoundException{
		//Searching the database for an Administrator with the ID
		Optional<Admin> adminOpt=adminRepo.findById(adminId);
		//If there is an Administrator with the given details isPresent method gives out true
		if(adminOpt.isPresent()) {
			//Using get() method to convert from optional to Admin type
			Admin deletedAdmin=adminOpt.get();
			AdminDto adminDto=new AdminDto();
			adminDto.setAdminId(deletedAdmin.getAdminId());
			adminDto.setAdminName(deletedAdmin.getAdminName());
			adminDto.setAdminEmail(deletedAdmin.getLogin().getLoginEmail());
			adminRepo.deleteById(adminId);
			return adminDto;
		}
		else {
			throw new AdminNotFoundException("Administrator not Found with the given ID: "+adminId);
		}
	}

	@Override
	public Admin updateAdmin(int adminId, Admin admin) throws AdminNotFoundException {
		//Searching the database for an Administrator with the ID
		Optional<Admin> adminOpt=adminRepo.findById(adminId);
		//If there is an Administrator with the given details isPresent method gives out true
		if(adminOpt.isPresent()) {
			Admin updateddAdmin=adminOpt.get();
			adminRepo.save(admin);
			return updateddAdmin;
		}
		else {
			throw new AdminNotFoundException("Administrator not Found with the given ID: "+adminId);
		}
	}

	@Override
	public List<Admin> getAllAdmin() {
		//Getting all the Administrator entries in the database using findAll() method
		List<Admin> admins=adminRepo.findAll();
		return admins;
	}

	@Override
	public List<AdminDto> getAllAdminDto() {
		//Getting all the Administrator entries in the database using findAll() method
		List<Admin> admins=adminRepo.findAll();
		//creating a AdminDto object of ArrayList type
		List<AdminDto> adminDtoList=new ArrayList<>();
		//Iterating through admins List
		for(Admin admin:admins) {
			AdminDto adminDto=new AdminDto();
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminName(admin.getAdminName());
			adminDto.setAdminEmail(admin.getLogin().getLoginEmail());
			adminDtoList.add(adminDto);
		}
		return adminDtoList;
	}

	@Override
	public AdminDto findAdminById(int adminId) throws AdminNotFoundException {
		Optional<Admin> admin=adminRepo.findById(adminId);
		if(admin.isPresent()) {
			Admin admin1=admin.get();
			AdminDto adminDto=new AdminDto();
			adminDto.setAdminId(admin1.getAdminId());
			adminDto.setAdminName(admin1.getAdminName());
			adminDto.setAdminEmail(admin1.getLogin().getLoginEmail());
			return adminDto;
		}
		else {
			throw new AdminNotFoundException("Administrator not Found with the given ID: "+adminId);
		}
		
	}


	@Override
	public AdminDto findAdminByName(String adminName) throws AdminNotFoundException {
		Optional<Admin> admin=adminRepo.findAdminByAdminName(adminName);
		if(admin.isPresent()) {
			Admin admin1=admin.get();
			AdminDto adminDto=new AdminDto();
			adminDto.setAdminId(admin1.getAdminId());
			adminDto.setAdminName(admin1.getAdminName());
			adminDto.setAdminEmail(admin1.getLogin().getLoginEmail());
			return adminDto;
		}
		else {
			throw new AdminNotFoundException("Administrator not Found with the given Name: "+adminName);
		}
	}

}
