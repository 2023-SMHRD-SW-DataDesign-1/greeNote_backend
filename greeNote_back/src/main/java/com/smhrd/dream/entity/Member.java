package com.smhrd.dream.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.smhrd.dream.controller.dto.MemberRequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
@Entity
public class Member {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String memberid;

	private String password;

	private String membername;

	private String nickname;

	@Enumerated(EnumType.STRING)
	private Authority authority;

	@Column(name = "profile_img")
	private String profileImg;

	@Builder
	public Member(String memberid, String password, String membername, String nickname, Authority authority,
			String profileImg) {
		this.memberid = memberid;
		this.password = password;
		this.membername = membername;
		this.nickname = nickname;
		this.authority = authority;
		this.profileImg = profileImg;
	}

	public void updateFromRequest(MemberRequestDto memberRequestDto, PasswordEncoder passwordEncoder) {
		// memberid 업데이트
		if (memberRequestDto.getMemberid() != null && !memberRequestDto.getMemberid().isEmpty()) {
			this.setMemberid(memberRequestDto.getMemberid());
		}

		// membername 업데이트
		if (memberRequestDto.getMembername() != null && !memberRequestDto.getMembername().isEmpty()) {
			this.setMembername(memberRequestDto.getMembername());
		}

		// nickname 업데이트
		if (memberRequestDto.getNickname() != null && !memberRequestDto.getNickname().isEmpty()) {
			this.setNickname(memberRequestDto.getNickname());
		}

		// password 업데이트
		String newPassword = memberRequestDto.getPassword();
		if (newPassword != null && !newPassword.isEmpty()) {
			// 비밀번호를 업데이트할 때, 비밀번호 암호화 필요
			String encodedPassword = passwordEncoder.encode(newPassword);
			this.setPassword(encodedPassword);
		}

		// profileImg 업데이트
		if (memberRequestDto.getProfileImg() != null && !memberRequestDto.getProfileImg().isEmpty()) {
			this.setProfileImg(memberRequestDto.getProfileImg());
		}
	}

}