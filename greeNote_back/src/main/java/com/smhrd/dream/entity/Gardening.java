package com.smhrd.dream.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="gardening")
@Entity
@Builder
public class Gardening {
	
	@Id
	@Column(name = "gardening_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gardening_id;
	
	private Long plant_id;
	
	private int watering;
	
    private int repotting;
    
    private int nutrition_management;
    
    private int ventilation;
    
    private boolean alarm;
    
    

}
