package com.smhrd.dream.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Table(name = "refresh_token")
@Entity
public class RefreshToken {

	@Column(name = "grantType")
	private String grantType;

	@Id
	@Column(name = "rt_key")
	private String key;

	@Column(name = "rt_value")
	private String value;

	@Column(name = "accessTokenExpiresIn")
	private Long accessTokenExpiresIn;

	@Builder
	public RefreshToken(String key, String value, String grantType, Long accessTokenExpiresIn) {
		this.key = key;
		this.value = value;
		this.grantType = grantType;
		this.accessTokenExpiresIn = accessTokenExpiresIn;
	}

	public RefreshToken updateValue(String token, String grantType, Long accessTokenExpiresIn) {
		this.value = token;
		this.grantType = grantType;
		this.accessTokenExpiresIn = accessTokenExpiresIn;
		return this;
	}
}
