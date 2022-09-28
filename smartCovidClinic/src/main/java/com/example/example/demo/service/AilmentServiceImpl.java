package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AilmentOutputDto;
import com.example.demo.entity.Ailment;
import com.example.demo.exception.AilmentExistsException;
import com.example.demo.exception.AilmentNotFoundException;
import com.example.demo.repository.IAilmentRepository;

@Service
public class AilmentServiceImpl implements IAilmentService {
	
	@Autowired
	IAilmentRepository ailRepo;
	
	private Logger logger = LogManager.getLogger();

	@Override
	public Ailment addAilment(Ailment ailment)throws AilmentExistsException {	
		Optional<Ailment> ailment1 = ailRepo.findByAilment(ailment.getAilment());
		if(ailment1.isPresent()) {
			throw new AilmentExistsException("Ailment already Exists with the name: " + ailment.getAilment());
		}
		else {
		Ailment newailment = ailRepo.save(ailment);
		return newailment;
		}
	}


	@Override
	public Ailment deleteAilmentById(int ailmentId) throws AilmentNotFoundException {
		logger.info("Sending delete request to Repository");
		Optional<Ailment> ailOpt = ailRepo.findById(ailmentId);
		if (ailOpt.isPresent()) {
			Ailment ail = ailOpt.get();
			ailRepo.deleteById(ailmentId);
			logger.info("Patient deleted successfully");
			return ail;
		} else {
			throw new AilmentNotFoundException("Ailment not found with given id: " + ailmentId);
		}
		
	}

	@Override
	public Ailment updateAilment(int ailmentId, Ailment ailment) throws AilmentNotFoundException {
		logger.info("Sending update request to Repository");
		Optional<Ailment> ailOpt = ailRepo.findById(ailmentId);
		if (ailOpt.isPresent()) {
		Ailment ail = ailOpt.get();
		ailRepo.save(ailment);
		logger.info("Patient updated successfully");
		return ail;
		} else {
			throw new AilmentNotFoundException("Ailment not found with given id: " + ailmentId);
		}
	}

	@Override
	public List<Ailment> getAllAilments() {
		logger.info("View All Ailments Request Sent to Repository");
		List<Ailment> ail = ailRepo.findAll();
		logger.info("Ailments viewed successfully");
		return ail;
	}


	@Override
	public List<AilmentOutputDto> getAllAilmentsDto() {
		List<Ailment> ailments = ailRepo.findAll();

		List<AilmentOutputDto> ailmentDtoList = new ArrayList<>();

		for (Ailment ailment : ailments) {

			AilmentOutputDto dto = new AilmentOutputDto();

			dto.setAilment(ailment.getAilment());

			ailmentDtoList.add(dto);
		}
		return ailmentDtoList;
	}
		
}