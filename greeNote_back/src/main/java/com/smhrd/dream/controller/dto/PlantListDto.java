package com.smhrd.dream.controller.dto;

import com.smhrd.dream.entity.Gardening;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantListDto {

	private Long plantId;
	private String image;
	private String title;
	private String start_date;
	private String watering_date;
	private String nickname;
	private String message;
	private String color;
	private Gardening gardening;
}
