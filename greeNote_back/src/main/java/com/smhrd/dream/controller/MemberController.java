package com.smhrd.dream.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.dream.controller.dto.MemberResponseDto;
import com.smhrd.dream.service.MemberService;
import com.smhrd.dream.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@CrossOrigin("https://localhost:3000")
public class MemberController {
	private final MemberService memberService;

	@GetMapping("/me")
	public ResponseEntity<MemberResponseDto> findMemberInfoById() {
		return ResponseEntity.ok(memberService.findMemberInfoById(SecurityUtil.getCurrentId()));
	}

	@GetMapping("/{memberid}")
	public ResponseEntity<MemberResponseDto> findMemberInfoByMemberid(@PathVariable String memberid) {
		System.out.println(memberid);
		return ResponseEntity.ok(memberService.findMemberInfoByMemberid(memberid));
	}
}
