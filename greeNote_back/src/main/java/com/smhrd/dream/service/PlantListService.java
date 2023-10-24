package com.smhrd.dream.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.smhrd.dream.controller.dto.PlantListDto;
import com.smhrd.dream.entity.PlantList;
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
	private final MemberService memberService;
	@Value("${jwt.secret}") String secretKey;

	public void submit(PlantListDto plantObj, String accessToken) {
		Long id = null;
		if(accessToken != null) {
			byte[] keyBytes = Decoders.BASE64.decode(secretKey);
			Claims claims = Jwts.parserBuilder()
				    .setSigningKey(Keys.hmacShaKeyFor(keyBytes))
				    .build()
				    .parseClaimsJws(accessToken)
				    .getBody();
			id = Long.parseLong(claims.getSubject());
		}
		PlantList plantList = new PlantList(null, id, plantObj.getImage(), plantObj.getTitle(), plantObj.getNickname(),
				plantObj.getMessage(), plantObj.getColor());
		plantListRepository.save(plantList);
	}
}