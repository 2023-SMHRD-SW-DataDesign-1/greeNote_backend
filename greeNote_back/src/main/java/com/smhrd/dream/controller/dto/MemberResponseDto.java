package com.smhrd.dream.controller.dto;

import com.smhrd.dream.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private String memberid;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getMemberid());
    }
}