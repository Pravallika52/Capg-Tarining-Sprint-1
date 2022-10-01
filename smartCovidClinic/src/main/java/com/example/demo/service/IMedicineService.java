package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Medicine;

public interface IMedicineService {
	Medicine addMedicine(Medicine medcine);
	Medicine removeMedicin(int medicineId);
	List<Medicine> getAllMedicine();

}
