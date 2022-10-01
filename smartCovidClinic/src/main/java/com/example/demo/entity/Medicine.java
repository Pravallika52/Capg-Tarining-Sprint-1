package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medicine {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="medicin_ailment_id")
	private Ailment Ailment;
	
	private String Medicine;

}
