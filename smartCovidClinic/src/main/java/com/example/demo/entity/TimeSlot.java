package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TimeSlot {
	
	@Id
	@GeneratedValue
	private int timeSlotId;

}
