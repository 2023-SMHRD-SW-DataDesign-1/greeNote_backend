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
@Table(name = "plant_list")
@Entity
@Builder
public class PlantList {
	
	@Id
	@Column(name = "plant_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long plant_id;
	
	private Long id;
	
	private String image_url;
	
    private String title;
    
    private String message;
    
    private String color;
    
}
