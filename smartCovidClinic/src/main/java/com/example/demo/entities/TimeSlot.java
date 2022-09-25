package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TimeSlot {
	
	@Id
	private int slotId;
	
	private int slot;
	
	private LocalDate date;
	
	

}
