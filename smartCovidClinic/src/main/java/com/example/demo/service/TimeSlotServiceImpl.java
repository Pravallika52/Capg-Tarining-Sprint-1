package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TimeSlot;
import com.example.demo.exception.SlotNotFoundException;
import com.example.demo.repository.ITimeslotRepository;

@Service
public class TimeSlotServiceImpl implements ITimeSlotService {
	
	@Autowired
	ITimeslotRepository timeRepo;

	@Override
	public TimeSlot addSlot(TimeSlot slot) {
		TimeSlot newslot = timeRepo.save(slot);
		return newslot;
	}

	@Override
	public TimeSlot updateSlot(int slotId, TimeSlot slot) throws SlotNotFoundException {
		Optional<TimeSlot> slotOpt=timeRepo.findById(slotId);
		if (slotOpt.isPresent()) {
			TimeSlot newslot = slotOpt.get();
		    timeRepo.save(slot);
		    return newslot;
	}
		else {
		      throw new SlotNotFoundException("Slot not found with the given ID:" + slotId);
		}
	}

	@Override
	public TimeSlot deleteSlotById(int slotId) throws SlotNotFoundException{
		Optional<TimeSlot> slotOpt=timeRepo.findById(slotId);
		if (slotOpt.isPresent()) {
			TimeSlot newslot = slotOpt.get();
		     timeRepo.deleteById(slotId);
		     return newslot;
	}else {
		throw new SlotNotFoundException("Slot not found with the given ID:" + slotId);
		}
	}


	@Override
	public List<TimeSlot> getAllSlot() {
		List<TimeSlot> allslot = timeRepo.findAll();
		return allslot;
	}

	@Override
	public TimeSlot getSlotById(int slotId) throws SlotNotFoundException {
		Optional<TimeSlot> slotOpt=timeRepo.findById(slotId);
		if (slotOpt.isPresent()) {
			TimeSlot newslot = slotOpt.get();
		     return newslot;
	} else {
		throw new SlotNotFoundException("Slot not found with the given ID:" + slotId);
		}
	}
	
	

}
