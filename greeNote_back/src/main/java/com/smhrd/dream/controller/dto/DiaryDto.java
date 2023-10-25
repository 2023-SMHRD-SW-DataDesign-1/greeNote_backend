package com.smhrd.dream.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDto {

	private Long plant_id;
	private String title;
	private String content;
	private String ai_result;
	private String registration_date;
	
	private Diary_ImageDto[] diary_imageDto;

}
