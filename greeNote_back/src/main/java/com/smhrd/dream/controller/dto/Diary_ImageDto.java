package com.smhrd.dream.controller.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diary_ImageDto implements Serializable{
	
	private String image_url;
	
}
