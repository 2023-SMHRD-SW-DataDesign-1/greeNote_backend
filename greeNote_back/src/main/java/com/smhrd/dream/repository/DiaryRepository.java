package com.smhrd.dream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.dream.entity.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long>{

}
