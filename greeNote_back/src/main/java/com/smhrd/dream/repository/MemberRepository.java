package com.smhrd.dream.repository;

import com.smhrd.dream.controller.dto.MemberRequestDto;
import com.smhrd.dream.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberid(String memberid);
    boolean existsByMemberid(String memberid);
}

