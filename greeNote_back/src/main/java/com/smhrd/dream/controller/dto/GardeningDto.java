package com.smhrd.dream.controller.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GardeningDto {

	private Long gardeningId;
	private Long plantId;
	private int watering;
	private int repotting;
	private int nutrition_management;
	private int ventilation;
	private boolean alarm;
}
