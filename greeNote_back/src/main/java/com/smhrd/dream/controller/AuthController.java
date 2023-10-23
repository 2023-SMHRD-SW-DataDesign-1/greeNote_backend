package com.smhrd.dream.controller;

import com.smhrd.dream.controller.dto.MemberRequestDto;
import com.smhrd.dream.controller.dto.MemberResponseDto;
import com.smhrd.dream.controller.dto.TokenRequestDto;
import com.smhrd.dream.controller.dto.TokenDto;
import com.smhrd.dream.service.AuthService;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("https://localhost:3000")
public class AuthController {
	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
		return ResponseEntity.ok(authService.signup(memberRequestDto));
	}

	@PostMapping("/login")
	public void login(@RequestBody MemberRequestDto memberRequestDto, HttpServletRequest request,
			HttpServletResponse response) {
		TokenDto jwt = authService.login(memberRequestDto);
		Cookie cookie1 = new Cookie("AccessToken", jwt.getAccessToken());
		cookie1.setPath("/");
		cookie1.setDomain("localhost");
		cookie1.setHttpOnly(true);
		cookie1.setMaxAge(3600);
		cookie1.setSecure(true);
		
		Cookie cookie2 = new Cookie("RefreshToken", jwt.getRefreshToken());
		cookie2.setPath("/");
		cookie2.setDomain("localhost");
		cookie2.setHttpOnly(true);
		cookie2.setMaxAge(7200000);
		cookie2.setSecure(true);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto, HttpServletRequest request,
//			HttpServletResponse response) {
//		TokenDto jwt = authService.login(memberRequestDto);
//		ResponseCookie cookie = ResponseCookie.from("RefreshToken",jwt.getRefreshToken())
//				.path("/")
//				.domain("localhost")
//				.httpOnly(true)
//				.maxAge(7200000)
//				.sameSite("None")
//				.secure(true)
//				.build();
//		Cookie cookie3 = new Cookie("AccessToken", jwt.getAccessToken());
//		ResponseCookie cookie2 = ResponseCookie.from("AccessToken",jwt.getAccessToken())
//				.path("/")
//				.domain("localhost")
//				.httpOnly(true)
//				.maxAge(7200000)
//				.sameSite("None")
//				.secure(true)
//				.build();
//		response.setHeader("SET-COOKIE", cookie.toString());
//		return ResponseEntity.ok(jwt);
//	}
	
	@PostMapping("/reissue")
	public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
		return ResponseEntity.ok(authService.reissue(tokenRequestDto));
	}
}
