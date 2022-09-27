package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SpecInputDto;
import com.example.demo.dto.SpecOutputDto;
import com.example.demo.entity.Specialization;
import com.example.demo.exception.SpecExistsException;
import com.example.demo.exception.SpecNotFoundException;

public interface ISpecializationService {
	
	Specialization addSpec(Specialization spec) throws SpecExistsException;
	Specialization updateSpec(int specId,Specialization spec) throws SpecNotFoundException;
	Specialization deleteSpecById(int specId)throws SpecNotFoundException;
	List<Specialization> getAllSpec(); 
	Specialization updateSpecDto(SpecInputDto spec);
	List<SpecOutputDto> getAllSpecDto();

}
