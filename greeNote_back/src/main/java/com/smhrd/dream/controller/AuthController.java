package com.smhrd.dream.controller;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.dream.controller.dto.MemberRequestDto;
import com.smhrd.dream.controller.dto.MemberResponseDto;
import com.smhrd.dream.controller.dto.TokenDto;
import com.smhrd.dream.controller.dto.TokenRequestDto;
import com.smhrd.dream.entity.Member;
import com.smhrd.dream.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
		System.out.println(memberRequestDto.getMemberid());
		return ResponseEntity.ok(authService.signup(memberRequestDto));
	}

	@PostMapping("/login")
	public Optional<Member> login(@RequestBody MemberRequestDto memberRequestDto, HttpServletRequest request,
			HttpServletResponse response) {
		TokenDto jwt = authService.login(memberRequestDto);
		ResponseCookie cookie1 = ResponseCookie.from("accessToken", jwt.getAccessToken())
				.path("/")
				.sameSite("None")
				.httpOnly(true)
				.domain("greenote.site")
				.maxAge(7200000)
				.secure(true)
				.build();
		
		ResponseCookie cookie2 = ResponseCookie.from("refreshToken", jwt.getRefreshToken())
				.path("/")
				.sameSite("None")
				.httpOnly(true)
				.domain("greenote.site")
				.maxAge(7200000)
				.secure(true)
				.build();
		
		response.setHeader("Set-Cookie", cookie1.toString());
		response.addHeader("Set-Cookie", cookie2.toString());
		
//		Cookie cookie1 = new Cookie("accessToken", jwt.getAccessToken());
//		cookie1.setPath("/");
//		cookie1.setDomain("greenote.site");
//		cookie1.setHttpOnly(true);
//		cookie1.setMaxAge(36000);
//		cookie1.setSecure(true);
//
//		Cookie cookie2 = new Cookie("refreshToken", jwt.getRefreshToken());
//		cookie2.setPath("/");
//		cookie2.setDomain("greenote.site");
//		cookie2.setHttpOnly(true);
//		cookie2.setMaxAge(7200000);
//		cookie2.setSecure(true);
//		
//		response.addCookie(cookie1);
//		response.addCookie(cookie2);

		return authService.memberInfo(jwt.getAccessToken());
	}

	@PostMapping("/update")
	public ResponseEntity<MemberResponseDto> updateMember(@RequestBody MemberRequestDto memberRequestDto) {
		return ResponseEntity.ok(authService.updateMember(memberRequestDto));
	}
	
	@GetMapping("/reissue")
	public void reissue(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		TokenRequestDto token = new TokenRequestDto();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				if (cookieName.equals("accessToken")) {
					token.setAccessToken(c.getValue());
				}
				if (cookieName.equals("refreshToken")) {
					token.setRefreshToken(c.getValue());
				}
			}
		}

		TokenDto jwt = authService.reissue(token);
		
		Cookie cookie1 = new Cookie("accessToken", jwt.getAccessToken());
		cookie1.setPath("/");
		cookie1.setDomain("greenote.site");
		cookie1.setHttpOnly(true);
		cookie1.setMaxAge(36000);
		cookie1.setSecure(true);

		Cookie cookie2 = new Cookie("refreshToken", jwt.getRefreshToken());
		cookie2.setPath("/");
		cookie2.setDomain("greenote.site");
		cookie2.setHttpOnly(true);
		cookie2.setMaxAge(7200000);
		cookie2.setSecure(true);

		response.addCookie(cookie1);
		response.addCookie(cookie2);
	}
}
