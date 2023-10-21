package com.smhrd.dream.controller;

import com.smhrd.dream.controller.dto.MemberRequestDto;
import com.smhrd.dream.controller.dto.MemberResponseDto;
import com.smhrd.dream.controller.dto.TokenRequestDto;
import com.smhrd.dream.controller.dto.TokenDto;
import com.smhrd.dream.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class AuthController {
	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
		return ResponseEntity.ok(authService.signup(memberRequestDto));
	}

	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
		return ResponseEntity.ok(authService.login(memberRequestDto));
	}

	@PostMapping("/reissue")
	public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
		return ResponseEntity.ok(authService.reissue(tokenRequestDto));
	}
}

