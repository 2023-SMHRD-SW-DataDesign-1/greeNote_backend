package com.smhrd.dream.controller.dto;

import com.smhrd.dream.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MemberResponseDto {
	
	private Long id;
	
	@NonNull
    private String memberid;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getMemberid());
    }
    
    public static MemberResponseDto duplicated(String message) {
    	return new MemberResponseDto(message);
    }    
    
}