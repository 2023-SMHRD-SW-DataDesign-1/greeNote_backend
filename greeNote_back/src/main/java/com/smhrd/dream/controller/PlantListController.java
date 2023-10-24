package com.smhrd.dream.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.dream.controller.dto.PlantListDto;
import com.smhrd.dream.service.MemberService;
import com.smhrd.dream.service.PlantListService;
import com.smhrd.dream.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plant")
public class PlantListController {
	
	private final PlantListService plantListService;

	@PostMapping("/addPlantList")
	public void addPlantList(@RequestBody JSONObject data, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("요청 처리 완료");
		plantListService.submit(data);
	}

}
