package com.toyproject.toyproject.service;

import com.toyproject.toyproject.Repository.MemberRepository;
import com.toyproject.toyproject.Repository.MemoryMemberRepository;
import com.toyproject.toyproject.member.Member;

public class MemberServiceImpl implements MemberService{

    //객체 생성을 짬 때리면서 실행에만 집중 함
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
