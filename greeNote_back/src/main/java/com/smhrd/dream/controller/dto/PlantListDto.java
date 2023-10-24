package com.smhrd.dream.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantListDto {

	private String image;
	private String title;
	private String start_date;
	private String watering_date;
	private String nickname;
	private String message;
	private String color;
	private GardeningDto gardeningDto;
}
