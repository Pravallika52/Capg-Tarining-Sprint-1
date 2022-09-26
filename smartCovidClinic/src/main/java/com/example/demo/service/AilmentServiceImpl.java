package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ailment;
import com.example.demo.exception.AilmentNotFoundException;
import com.example.demo.repository.IAilmentRepository;

@Service
public class AilmentServiceImpl implements IAilmentService{
	
	@Autowired
	IAilmentRepository ailRepo;

	@Override
	public Ailment addAilment(Ailment ailment) {
		Ailment ail = ailRepo.save(ailment);
		return ail;
	}


	@Override
	public Ailment deleteAilmentById(int ailmentId) throws AilmentNotFoundException {
		Optional<Ailment> ailOpt = ailRepo.findById(ailmentId);
		if (ailOpt.isPresent()) {
			Ailment ail = ailOpt.get();
			ailRepo.deleteById(ailmentId);
			return ail;
		} else {
			throw new AilmentNotFoundException("Ailment not found with given id: " + ailmentId);
		}
		
	}

	@Override
	public Ailment updateAilment(int ailmentId, Ailment ailment) throws AilmentNotFoundException {
		Optional<Ailment> ailOpt = ailRepo.findById(ailmentId);
		if (ailOpt.isPresent()) {
		Ailment ail = ailOpt.get();
		ailRepo.save(ailment);
		return ail;
		} else {
			throw new AilmentNotFoundException("Ailment not found with given id: " + ailmentId);
		}
	}

	@Override
	public List<Ailment> getAllAilments() {
		List<Ailment> ail = ailRepo.findAll();
		return ail;
	}


}
