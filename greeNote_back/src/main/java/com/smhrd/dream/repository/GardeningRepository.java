package com.smhrd.dream.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.dream.controller.dto.GardeningDto;
import com.smhrd.dream.entity.Gardening;

public interface GardeningRepository extends JpaRepository<Gardening, Long>{
	Gardening findByPlantId(Long plantId);
}
