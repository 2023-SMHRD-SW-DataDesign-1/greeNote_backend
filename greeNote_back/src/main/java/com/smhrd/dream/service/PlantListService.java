package com.smhrd.dream.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.smhrd.dream.controller.dto.DiaryCombinDto;
import com.smhrd.dream.controller.dto.GardeningDto;
import com.smhrd.dream.controller.dto.PlantListDto;
import com.smhrd.dream.entity.Diary;
import com.smhrd.dream.entity.Gardening;
import com.smhrd.dream.entity.PlantList;
import com.smhrd.dream.repository.DiaryRepository;
import com.smhrd.dream.repository.Diary_ImageRepository;
import com.smhrd.dream.repository.GardeningRepository;
import com.smhrd.dream.repository.PlantListRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlantListService {

	private final PlantListRepository plantListRepository;
	private final GardeningRepository gardeningRepository;
	private final DiaryRepository diaryRepository;
	private final Diary_ImageRepository diary_ImageRepository;

	@Value("${jwt.secret}")
	String secretKey;

	public List<Object> submit(PlantListDto plantObj, String accessToken) {
		Long id = null;
		if (accessToken != null) {
			byte[] keyBytes = Decoders.BASE64.decode(secretKey);
			Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(keyBytes)).build()
					.parseClaimsJws(accessToken).getBody();
			id = Long.parseLong(claims.getSubject());
		}

		PlantList plantList = new PlantList(null, id, plantObj.getImage(), plantObj.getTitle(), plantObj.getNickname(),
				plantObj.getMessage(), plantObj.getColor(), plantObj.getStart_date(), plantObj.getWatering_date());
		PlantList plantResult = plantListRepository.save(plantList);

		Gardening gardeningDto = plantObj.getGardening();
		Gardening gardening = new Gardening(null, plantResult.getPlantId(), gardeningDto.getWatering(),
				gardeningDto.getRepotting(), gardeningDto.getNutrition_management(), gardeningDto.getVentilation(),
				false);
		Gardening gardenResult = gardeningRepository.save(gardening);

		List<Object> result = new ArrayList<>();
		result.add(plantResult);
		result.add(gardenResult);

		return result;
	}

	public List<PlantListDto> readPlantList(String accessToken) {
		Long id = null;
		if (accessToken != null) {
			byte[] keyBytes = Decoders.BASE64.decode(secretKey);
			Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(keyBytes)).build()
					.parseClaimsJws(accessToken).getBody();
			id = Long.parseLong(claims.getSubject());
		}
		List<PlantList> plantList = plantListRepository.findAllById(id);
		Gardening gardening = null;
		List<PlantListDto> plantCombinList = new ArrayList<>();
		if (plantList != null) {
			for (int i = 0; i < plantList.size(); i++) {
				gardening = gardeningRepository.findByPlantId(plantList.get(0).getPlantId());
				PlantList plant = plantList.get(i);
				PlantListDto plantCombin = new PlantListDto(plant.getPlantId(), plant.getImage_url(), plant.getTitle(),
						plant.getStart_date(), plant.getWatering_date(), plant.getNickname(), plant.getMessage(),
						plant.getColor(), gardening);
				plantCombinList.add(plantCombin);
			}
		}
		return plantCombinList;
	}

	public String deletePlant(String plantId) {
		try {
			List<Diary> diaryList = diaryRepository.findAllByPlantId(Long.parseLong(plantId));
			for (Diary diary : diaryList) {
				diary_ImageRepository.delete(diary_ImageRepository.findByDiaryId(diary.getDiaryId()));
				diaryRepository.delete(diaryRepository.findByDiaryId(diary.getDiaryId()));
			}
			gardeningRepository.delete(gardeningRepository.findByPlantId(Long.parseLong(plantId)));
			plantListRepository.delete(plantListRepository.findByPlantId(Long.parseLong(plantId)));
			
			String result = "success";
			return result;
		} catch (Exception e) {
			System.out.println(e);
			String result = "fail";
			return result;
		}
	}
}
