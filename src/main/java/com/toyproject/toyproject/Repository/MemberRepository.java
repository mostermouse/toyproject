package com.toyproject.toyproject.Repository;

import com.toyproject.toyproject.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
