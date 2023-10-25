package com.smhrd.dream.controller.dto;

import com.smhrd.dream.entity.Authority;
import com.smhrd.dream.entity.Member;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    private String memberid;
    private String membername;
    private String nickname;
    private String password;
    private String profileImg;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .memberid(memberid)
                .password(passwordEncoder.encode(password))
                .membername(membername)
                .nickname(nickname)
                .profileImg(profileImg)
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(memberid, password);
    }
}
