package com.smhrd.dream.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.dream.entity.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long>{
	List<Diary> findAllByPlantId(Long plantId);
}
