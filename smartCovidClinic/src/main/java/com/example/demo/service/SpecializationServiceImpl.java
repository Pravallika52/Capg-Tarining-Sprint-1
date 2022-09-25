package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Specialization;
import com.example.demo.exception.SpecNotFoundException;
import com.example.demo.repository.ISpecializationRepository;

@Service
public class SpecializationServiceImpl implements ISpecializationService {
	
	@Autowired
	ISpecializationRepository specRepo;

	@Override
	public Specialization addSpec(Specialization spec) {
		Specialization newspec = specRepo.save(spec);
		return newspec;
	}

	@Override
	public Specialization updateSpec(int specId, Specialization spec) throws SpecNotFoundException {
		Optional<Specialization> specOpt=specRepo.findById(specId);
		if (specOpt.isPresent()) {
			Specialization newspec = specOpt.get();
		    return specRepo.save(spec);
		} else {
			throw new SpecNotFoundException("Specialization not found with given id: " + specId);
		}
	}

	@Override
	public Specialization deleteSpecById(int specId)throws SpecNotFoundException {
		Optional<Specialization> specOpt=specRepo.findById(specId);
		if (specOpt.isPresent()) {
			Specialization deletedspec = specOpt.get();
			specRepo.deleteById(specId);
			return deletedspec;
		} else {
			throw new SpecNotFoundException("Specialization not found with given id: " + specId);
		}
	}

	@Override
	public List<Specialization> getAllSpec() {
		List<Specialization> allspec = specRepo.findAll();
		return allspec;
	}

}
