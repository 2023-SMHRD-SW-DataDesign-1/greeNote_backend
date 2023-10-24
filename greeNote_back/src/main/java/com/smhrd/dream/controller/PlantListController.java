package com.smhrd.dream.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.dream.controller.dto.PlantListDto;
import com.smhrd.dream.service.PlantListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plant")
public class PlantListController {

	private final PlantListService plantListService;

	@PostMapping("/addPlantList")
	public void addPlantList(@RequestBody PlantListDto plantObj, HttpServletRequest request) {
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
		plantListService.submit(plantObj, accessToken);
	}

}
