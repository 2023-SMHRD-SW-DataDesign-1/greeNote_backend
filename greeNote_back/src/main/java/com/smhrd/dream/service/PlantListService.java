package com.smhrd.dream.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.smhrd.dream.controller.dto.PlantListDto;
import com.smhrd.dream.entity.PlantList;
import com.smhrd.dream.repository.PlantListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlantListService {
	
	private final PlantListRepository plantListRepository;

	public void submit(JSONObject data) {
		PlantList plantList = new PlantList(null, null, "123", "123", "123", "123");
		plantListRepository.save(plantList);
	}

}
