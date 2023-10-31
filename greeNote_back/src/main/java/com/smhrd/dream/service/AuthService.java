package com.smhrd.dream.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smhrd.dream.controller.dto.MemberRequestDto;
import com.smhrd.dream.controller.dto.MemberResponseDto;
import com.smhrd.dream.controller.dto.TokenDto;
import com.smhrd.dream.controller.dto.TokenRequestDto;
import com.smhrd.dream.entity.Member;
import com.smhrd.dream.entity.RefreshToken;
import com.smhrd.dream.jwt.TokenProvider;
import com.smhrd.dream.repository.MemberRepository;
import com.smhrd.dream.repository.RefreshTokenRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;
	private final RefreshTokenRepository refreshTokenRepository;
	@Value("${jwt.secret}")
	String secretKey;

	@Transactional
	public MemberResponseDto signup(MemberRequestDto memberRequestDto) {
		if (memberRepository.existsByMemberid(memberRequestDto.getMemberid())) {
			// 아이디 중복 시 흐름 작성
			String message = "중복된 아이디 입니다.";
			return MemberResponseDto.duplicated(message);
		}

		Member member = memberRequestDto.toMember(passwordEncoder);
		return MemberResponseDto.of(memberRepository.save(member));
	}

	@Transactional
	public TokenDto login(MemberRequestDto memberRequestDto) {
		// 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
		UsernamePasswordAuthenticationToken authenticationToken = memberRequestDto.toAuthentication();

		// 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
		// authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername
		// 메서드가 실행됨
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

		// 3. 인증 정보를 기반으로 JWT 토큰 생성
		TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

		// 4. RefreshToken 저장
		RefreshToken refreshToken = RefreshToken.builder().key(authentication.getName())
				.value(tokenDto.getRefreshToken()).grantType(tokenDto.getGrantType())
				.accessTokenExpiresIn(tokenDto.getAccessTokenExpiresIn()).build();

		refreshTokenRepository.save(refreshToken);

		// 5. 토큰 발급
		return tokenDto;
	}

	@Transactional
	public TokenDto reissue(TokenRequestDto tokenRequestDto) {
		// 1. Refresh Token 검증
		if (!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
			throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
			// 로그아웃을 하지 않았지만, 리프레시 토큰이 만료되었다면 다시 로그인 하도록 유도할 것
		}

		// 2. Access Token 에서 Member ID 가져오기
		Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

		// 3. 저장소에서 Member ID 를 기반으로 Refresh Token 값 가져옴
		RefreshToken refreshToken = refreshTokenRepository.findByKey(authentication.getName())
				.orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));
		// 로그아웃 명령 시 해당 리프레시 토큰을 삭제하게 만들고, 사용자는 다시 로그인 하도록 유도할 것

		// 4. Refresh Token 일치하는지 검사
		if (!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
			throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
			// 사용 거부 명령을 전달한 뒤 로그인 페이지로 유도할 것
		}

		// 5. 새로운 토큰 생성
		TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

		// 6. 저장소 정보 업데이트
		RefreshToken newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken(), tokenDto.getGrantType(),
				tokenDto.getAccessTokenExpiresIn());
		refreshTokenRepository.save(newRefreshToken);

		// 토큰 발급
		return tokenDto;
	}

	public Optional<Member> memberInfo(String accessToken) {
		Long id = null;
		if (accessToken != null) {
			byte[] keyBytes = Decoders.BASE64.decode(secretKey);
			Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(keyBytes)).build()
					.parseClaimsJws(accessToken).getBody();
			id = Long.parseLong(claims.getSubject());
		}
		return memberRepository.findById(id);
	}

	public MemberResponseDto updateMember(MemberRequestDto memberRequestDto) {
		// MemberRequestDto에서 memberid 가져오기
		String memberid = memberRequestDto.getMemberid();

		// memberid를 사용하여 기존 회원 엔티티 검색
		Optional<Member> existingMember = memberRepository.findByMemberid(memberid);

		if (existingMember.isPresent()) {
			// 기존 회원 엔티티가 존재하면 업데이트
			Member member = existingMember.get();
			member.updateFromRequest(memberRequestDto, passwordEncoder); // 업데이트 로직 적용

			// 업데이트된 회원 엔티티를 저장하고 MemberResponseDto로 변환
			return MemberResponseDto.of(memberRepository.save(member));
		} else {
			// 기존 회원 엔티티가 없으면 새로운 회원 엔티티 생성
			Member member = memberRequestDto.toMember(passwordEncoder);

			// 새로운 회원 엔티티를 저장하고 MemberResponseDto로 변환
			return MemberResponseDto.of(memberRepository.save(member));
		}
	}
}
