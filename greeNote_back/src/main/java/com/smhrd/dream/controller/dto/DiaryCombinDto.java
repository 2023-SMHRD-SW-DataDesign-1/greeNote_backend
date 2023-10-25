package com.smhrd.dream.controller.dto;

import com.smhrd.dream.entity.Diary;
import com.smhrd.dream.entity.Diary_Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaryCombinDto {

	private Diary diary;
	private Diary_Image imgUrl;

}
