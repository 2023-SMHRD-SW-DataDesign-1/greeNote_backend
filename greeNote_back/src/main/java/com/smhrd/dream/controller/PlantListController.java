package com.smhrd.dream.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.dream.controller.dto.PlantListDto;
import com.smhrd.dream.entity.PlantList;
import com.smhrd.dream.service.PlantListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plant")
public class PlantListController {

	private final PlantListService plantListService;

	@PostMapping("/addPlantList")
	public ResponseEntity<List<Object>> addPlantList(@RequestBody PlantListDto plantObj, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String accessToken = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("accessToken".equals(cookie.getName())) {
					 accessToken = cookie.getValue();
				}
			}
		}
		return ResponseEntity.ok(plantListService.submit(plantObj, accessToken));
	}

	@GetMapping("/readPlantList")
	public List<PlantListDto> readPlantList(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String accessToken = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("accessToken".equals(cookie.getName())) {
					 accessToken = cookie.getValue();
				}
			}
		}
		return plantListService.readPlantList(accessToken);
	}
	
	@GetMapping("/deletePlant")
	public String deletePlant(@RequestParam String plantId) {
		return plantListService.deletePlant(plantId);
	}
}
