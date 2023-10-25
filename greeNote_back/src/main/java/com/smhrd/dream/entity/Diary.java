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
@Table(name = "diary")
@Entity
@Builder
public class Diary {

	private Long id;
	
	@Id
	@Column(name = "diary_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long diary_id;

	@Column(name = "plant_id")
	private Long plantId;
	
	private String title;
	
	private String content;
	
	private String ai_result;
	
	private String registration_date;
	
}
