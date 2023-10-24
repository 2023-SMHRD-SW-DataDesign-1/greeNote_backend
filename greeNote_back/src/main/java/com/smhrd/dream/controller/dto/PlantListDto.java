package com.smhrd.dream.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantListDto {
	
	private Long id;
	private String image_url;
    private String title;
    private String message;
    private String color;

}
