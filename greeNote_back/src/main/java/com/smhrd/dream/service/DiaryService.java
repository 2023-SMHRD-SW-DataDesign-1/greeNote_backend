package com.smhrd.dream.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.dream.controller.dto.DiaryDto;
import com.smhrd.dream.entity.Diary;
import com.smhrd.dream.entity.Diary_Image;
import com.smhrd.dream.repository.DiaryRepository;
import com.smhrd.dream.repository.Diary_ImageRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryService {

	@Autowired
	private final DiaryRepository diaryRepository;
	@Autowired
	private final Diary_ImageRepository diary_ImageRepository;

	@Value("${jwt.secret}")
	String secretKey;

	public List<Object> submit(DiaryDto diaryDto, String accessToken) {
		try {
			Long id = null;
			if (accessToken != null) {
				byte[] keyBytes = Decoders.BASE64.decode(secretKey);
				Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(keyBytes)).build()
						.parseClaimsJws(accessToken).getBody();
				id = Long.parseLong(claims.getSubject());
			}

			// Plant_id는 현재 임의의 값 넣어놨음. 나중에 조회 기능 만들때 client에서부터 가져올 수 있도록 할 것
			Diary diary = new Diary(id, null, diaryDto.getPlant_id(), diaryDto.getTitle(), diaryDto.getContent(),
					diaryDto.getAi_result());
			Diary diaryResult = diaryRepository.save(diary);

			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArray;
			jsonArray = objectMapper.writeValueAsString(diaryDto.getDiary_imageDto());
			
			Diary_Image diary_image = new Diary_Image(id, diaryResult.getDiary_id(), jsonArray);
			Diary_Image diary_imageResult = diary_ImageRepository.save(diary_image);

			List<Object> result = new ArrayList<>();
			result.add(diaryResult);
			result.add(diary_imageResult);
			return result;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}

	}
}
