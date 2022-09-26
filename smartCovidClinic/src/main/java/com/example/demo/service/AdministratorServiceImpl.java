package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Administrator;
import com.example.demo.exception.AdministratorFoundException;
import com.example.demo.exception.AdministratorNotFoundException;
import com.example.demo.exception.PasswordNotSameException;
import com.example.demo.repository.IAdministratorRepository;

@Service
public class AdministratorServiceImpl implements IAdministratorService {

	@Autowired
	IAdministratorRepository admRepo;


	@Override
	public Administrator addAdmin(Administrator admin) throws PasswordNotSameException, AdministratorFoundException {
		
		Optional<Administrator> adminOpt1 = admRepo.getAdminByName(admin.getAdminName());
		Optional<Administrator> adminOpt2 = admRepo.getAdminByEmail(admin.getAdminEmail());
		if(adminOpt1.isPresent()) {
			throw new AdministratorFoundException("Admin Already Exists with the following Name: "+admin.getAdminName());
		}
		if(adminOpt2.isPresent()) {
			throw new AdministratorFoundException("Admin Already Exists with the following Email: "+admin.getAdminEmail());
		}
		String p=admin.getAdminPassword();
		String p2=admin.getAdminConfirmPassword();
		if(!p.equals(p2)) {
			throw new PasswordNotSameException("Password and Confirm Password should be the same");
		}
		Administrator newAdmin=admRepo.save(admin);
		return newAdmin;
	}

	@Override
	public Administrator deleteAdmin(int adminId) throws AdministratorNotFoundException {
		// TODO Auto-generated method stub
		Optional<Administrator> deletedAdmin = admRepo.findById(adminId);
		if(deletedAdmin.isPresent()) {
			Administrator delAdmin = deletedAdmin.get();
			admRepo.deleteById(adminId);
			return delAdmin;
		} else {
			throw new AdministratorNotFoundException("Admin not found with following id : "+adminId	);
		}
		
	}

	@Override
	public Administrator updateAdmin(int adminId, Administrator admin) throws AdministratorNotFoundException {
		// TODO Auto-generated method stub
		Optional<Administrator> updatedAdmin=admRepo.findById(adminId);
		if(updatedAdmin.isPresent()) {
			return admRepo.save(admin);
		} else {
			throw new AdministratorNotFoundException("Admin not found with following id : "+adminId);
		}
		
	}

	@Override
	public Administrator getAdminById(int adminId) throws AdministratorNotFoundException {
		// TODO Auto-generated method stub
		Optional<Administrator> viewAdmin=admRepo.findById(adminId);
		if(viewAdmin.isPresent()) {
			return viewAdmin.get();
		} else {
			throw new AdministratorNotFoundException("Admin not found with following id : "+adminId);
		}
	}

	@Override
	public List<Administrator> getAllAdmin() {
		// TODO Auto-generated method stub
		List<Administrator> allAdmin = admRepo.findAll();
		return allAdmin;
	}

	@Override
	public Administrator getAdminByEmail(String adminEmail) throws AdministratorNotFoundException {
		// TODO Auto-generated method stub
		Optional<Administrator> viewAdmin=admRepo.getAdminByEmail(adminEmail);
		if(viewAdmin.isPresent()) {
			return viewAdmin.get();
		} else {
			throw new AdministratorNotFoundException("Admin not found with following Email : "+adminEmail);
		}
	}

	@Override
	public Administrator getAdminByName(String adminName) throws AdministratorNotFoundException {
		// TODO Auto-generated method stub
		Optional<Administrator> viewAdmin = admRepo.getAdminByName(adminName);
		if(viewAdmin.isPresent()) {
			return viewAdmin.get();
		} else {
			throw new AdministratorNotFoundException("Admin not found with following name : "+adminName);
		}
	}
}
