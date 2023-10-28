package com.smhrd.dream.repository;

import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.smhrd.dream.entity.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long>, JpaSpecificationExecutor<Diary>{
	List<Diary> findAllByPlantId(Long plantId);
	Diary findByDiaryId(Long diaryId);
}
