package com.toyproject.toyproject.service;

import com.toyproject.toyproject.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
