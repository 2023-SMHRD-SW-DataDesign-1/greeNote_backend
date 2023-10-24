package com.smhrd.dream.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Builder
	public Member(String memberid, String password, String membername, String nickname, Authority authority) {
		this.memberid = memberid;
		this.password = password;
		this.membername = membername;
		this.nickname = nickname;
		this.authority = authority;
	}	
	
}