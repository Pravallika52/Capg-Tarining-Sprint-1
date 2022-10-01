package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Medicine;
import com.example.demo.repository.IMedicineRepository;

@Service
public class MedicineServiceImpl implements IMedicineService{

	
	@Autowired
	IMedicineRepository medRepo;
	
	@Override
	public Medicine addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		Medicine med=medRepo.save(medicine);
		return med;
	}

	@Override
	public Medicine removeMedicin(int medicineId) {
		// TODO Auto-generated method stub
		Optional<Medicine> medOpt=medRepo.findById(medicineId);
		medRepo.deleteById(medicineId);
		return medOpt.get();
	}

	@Override
	public List<Medicine> getAllMedicine() {
		// TODO Auto-generated method stub
		List<Medicine> medicines=medRepo.findAll();
		return medicines;
	}

}
