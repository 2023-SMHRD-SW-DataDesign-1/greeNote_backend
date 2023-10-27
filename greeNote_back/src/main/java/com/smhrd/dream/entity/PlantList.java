package com.smhrd.dream.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	private Long plantId;
	
	private Long id;
	
	private String image_url;
	
    private String title;
    
    private String nickname;
    
    private String message;
    
    private String color;
    
    private String start_date;

    private String watering_date;
}
