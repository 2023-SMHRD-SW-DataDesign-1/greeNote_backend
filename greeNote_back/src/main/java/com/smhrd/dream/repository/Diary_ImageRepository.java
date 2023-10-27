package com.smhrd.dream.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.dream.entity.Diary_Image;

public interface Diary_ImageRepository extends JpaRepository<Diary_Image, Long>{
	Diary_Image findByDiaryId(Long diaryId);
}
