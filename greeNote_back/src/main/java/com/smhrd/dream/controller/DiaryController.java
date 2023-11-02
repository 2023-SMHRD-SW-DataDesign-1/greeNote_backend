package com.smhrd.dream.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.dream.controller.dto.DiaryCombinDto;
import com.smhrd.dream.controller.dto.DiaryDto;
import com.smhrd.dream.entity.Diary;
import com.smhrd.dream.entity.Diary_Image;
import com.smhrd.dream.service.DiaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	private final DiaryService diaryService;

	@PostMapping("/addDiary")
	public ResponseEntity<List<Object>> addDiary(@RequestBody DiaryDto diaryDto, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String accessToken = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("accessToken".equals(cookie.getName())) {
					accessToken = cookie.getValue();
				}
			}
		}
		return ResponseEntity.ok(diaryService.submit(diaryDto, accessToken));
	}
	
	@GetMapping("/readDiary/{plant_id}")
	public List<DiaryCombinDto> readDiary(@PathVariable String plant_id) {
		System.out.println(plant_id);
		List<DiaryCombinDto> diaryList = diaryService.readDiary(plant_id);
		return diaryList;
	}

	@GetMapping("/readByDay")
	public List<DiaryCombinDto> readByDay(@RequestParam String registration_date, HttpServletRequest request) {
		System.out.println(registration_date);
		Cookie[] cookies = request.getCookies();
		String accessToken = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("accessToken".equals(cookie.getName())) {
					accessToken = cookie.getValue();
				}
			}
		}
		return diaryService.readByDay(registration_date, accessToken);
	}
	
	@GetMapping("/readOneDiary")
	public DiaryCombinDto readOneDiary(@RequestParam String diaryId) {
		return diaryService.readOneDiary(diaryId);
	}
	
	@GetMapping("/readDiaryImg")
	public List<Diary_Image> readDiaryImg (@RequestParam String plantId) {
		return diaryService.readDiaryImg(plantId);
	}
	
	@DeleteMapping("/deleteDiary")
	public String deleteDiary (@RequestParam String diaryId) {
		return diaryService.deleteDiary(diaryId);
	}
	
}
