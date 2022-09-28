package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TimeSlot;
import com.example.demo.exception.SlotNotFoundException;

public interface ITimeSlotService {
	
	TimeSlot addSlot(TimeSlot slot);
	TimeSlot updateSlot(int slotId,TimeSlot slot) throws SlotNotFoundException;
	TimeSlot deleteSlotById(int slotId)  throws SlotNotFoundException ;
	List<TimeSlot> getAllSlot(); 
	TimeSlot getSlotById(int slotId) throws SlotNotFoundException;

}
