package com.smhrd.dream.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.dream.controller.dto.DiaryDto;
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
//		System.out.println(diaryDto.getDiary_imageDto()[2].getImage_url());
		Cookie[] cookies = request.getCookies();
		String accessToken = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("accessToken".equals(cookie.getName())) {
					// 쿠키 이름이 "accessToken"인 경우 해당 쿠키의 값을 얻습니다.
					accessToken = cookie.getValue();
					// accessToken을 Service로 전달하거나 사용할 수 있습니다.
				}
			}
		}
		return ResponseEntity.ok(diaryService.submit(diaryDto, accessToken));
	}

}
