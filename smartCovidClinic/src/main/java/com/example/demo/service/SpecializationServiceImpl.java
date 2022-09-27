package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SpecInputDto;
import com.example.demo.dto.SpecOutputDto;
import com.example.demo.entity.Specialization;
import com.example.demo.exception.SpecExistsException;
import com.example.demo.exception.SpecNotFoundException;
import com.example.demo.repository.ISpecializationRepository;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	ISpecializationRepository specRepo;
	
	private static Logger logger = LogManager.getLogger();

	@Override
	public Specialization addSpec(Specialization spec)throws SpecExistsException {
		logger.info("Sending addSpec request to repository");
		Optional<Specialization> specOpt = specRepo.findByName(spec.getSpecName());
		if(specOpt.isPresent()) {
			throw new SpecExistsException("Specialization already exists with the given Name: "+spec.getSpecName());
		}else {
			Specialization newspec = specRepo.save(spec);
			logger.info("Added spec successfully");
			return newspec;
		}
		
	}

	@Override
	public Specialization updateSpec(int specId, Specialization spec) throws SpecNotFoundException {
		Optional<Specialization> specOpt = specRepo.findById(specId);
		if (specOpt.isPresent()) {
			Specialization newspec = specOpt.get();
			return specRepo.save(spec);
		} else {
			throw new SpecNotFoundException("Specialization not found with given id: " + specId);
		}
	}

	@Override
	public Specialization deleteSpecById(int specId) throws SpecNotFoundException {
		Optional<Specialization> specOpt = specRepo.findById(specId);
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

	@Override
	public Specialization updateSpecDto(SpecInputDto spec) {

		return null;
	}

	@Override
	public List<SpecOutputDto> getAllSpecDto() {
		List<Specialization> specs = specRepo.findAll();

		List<SpecOutputDto> specDtoList = new ArrayList<>();

		for (Specialization spec : specs) {

			SpecOutputDto dto = new SpecOutputDto();

			dto.setSpecId(spec.getSpecId());
			dto.setSpecName(spec.getSpecName());

			specDtoList.add(dto);
		}
		return specDtoList;
	}

}
