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
	private String startDate;
	private String wateringDate;
	private String nickname;
	private String message;
	private String color;
	private GardeningDto gardeningDto;

	public GardeningDto getGardeningDto() {
		return gardeningDto;
	}

	public void setGardeningDto(GardeningDto gardeningDto) {
		this.gardeningDto = gardeningDto;
	}
}
