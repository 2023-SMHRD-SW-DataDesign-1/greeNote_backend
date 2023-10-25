package com.smhrd.dream.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.smhrd.dream.controller.dto.Diary_ImageDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "diary_image")
@Entity
@Builder
public class Diary_Image {

	private Long id;

	@Id
	@Column(name = "diary_id")
	private Long diaryId;

	private String image_url;
	
	private String registration_date;

}
