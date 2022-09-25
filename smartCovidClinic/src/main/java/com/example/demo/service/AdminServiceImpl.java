package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDto;
import com.example.demo.entity.Admin;
import com.example.demo.exception.AdminExistsException;
import com.example.demo.exception.AdminNotFoundException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.repository.IAdminRepository;


@Service
public class AdminServiceImpl implements IAdminService{

	
	@Autowired
	IAdminRepository adminRepo;
	
	@Override
	public Admin addAdmin(Admin admin) throws AdminExistsException, PasswordNotSameException{
		// TODO Auto-generated method stub
//		Admin newAdmin=adminRepo.save(admin);
//		return newAdmin;
		Optional<Admin> adminOpt1 = adminRepo.findAdminByName(admin.getAdminName());
		Optional<Admin> adminOpt2 = adminRepo.findAdminByEmail(admin.getAdminEmail());
		if(adminOpt1.isPresent()) {
			throw new AdminExistsException("Admin Already Exists with the given Name: "+admin.getAdminName());
		}
		if(adminOpt2.isPresent()) {
			throw new AdminExistsException("Admin Already Exists with the given Email: "+admin.getAdminEmail());
		}
		String p=admin.getAdminPassword();
		String p2=admin.getAdminConfirmPassword();
		if(!p.equals(p2)) {
			throw new PasswordNotSameException("Password and Confirm Password should be the same");
		}
		Admin newAdmin=adminRepo.save(admin);
		return newAdmin;
	}

	@Override
	public Admin removeAdminById(int adminId) throws AdminNotFoundException{
		// TODO Auto-generated method stub
		Optional<Admin> adminOpt=adminRepo.findById(adminId);
		if(adminOpt.isPresent()) {
			Admin deletedAdmin=adminOpt.get();
			adminRepo.deleteById(adminId);
			return deletedAdmin;
		}
		else {
			throw new AdminNotFoundException("Administrator not Found with the given ID: "+adminId);
		}
	}

	@Override
	public Admin updateAdmin(int adminId, Admin admin) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> adminOpt=adminRepo.findById(adminId);
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
		// TODO Auto-generated method stub
		List<Admin> admins=adminRepo.findAll();
		return admins;
	}

	@Override
	public List<AdminDto> getAllAdminDto() {
		// TODO Auto-generated method stub
		List<Admin> admins=adminRepo.findAll();
		List<AdminDto> adminDtoList=new ArrayList<>();
		for(Admin admin:admins) {
			AdminDto adminDto=new AdminDto();
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminName(admin.getAdminName());
			adminDto.setAdminEmail(admin.getAdminEmail());
			adminDtoList.add(adminDto);
		}
		return adminDtoList;
	}

	@Override
	public Admin findAdminById(int adminId) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> admin=adminRepo.findById(adminId);
		if(admin.isPresent()) {
			return admin.get();
		}
		else {
			throw new AdminNotFoundException("Administrator not Found with the given ID: "+adminId);
		}
		
	}

	@Override
	public Admin findAdminByEmail(String adminEmail) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> admin=adminRepo.findAdminByEmail(adminEmail);
		if(admin.isPresent()) {
			return admin.get();
		}
		else {
			throw new AdminNotFoundException("Administrator not Found with the given Email: "+adminEmail);
		}
	}

	@Override
	public Admin findAdminByName(String adminName) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> admin=adminRepo.findAdminByName(adminName);
		if(admin.isPresent()) {
			return admin.get();
		}
		else {
			throw new AdminNotFoundException("Administrator not Found with the given Name: "+adminName);
		}
	}

}
