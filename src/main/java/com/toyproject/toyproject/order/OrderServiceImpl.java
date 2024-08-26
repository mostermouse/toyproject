package com.toyproject.toyproject.order;

import com.toyproject.toyproject.Repository.MemberRepository;
import com.toyproject.toyproject.discount.DiscountPolicy;
import com.toyproject.toyproject.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice =  discountPolicy.discount(member , itemPrice );

        return new Order(memberId , itemName , itemPrice , discountPrice);
    }

    //Test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
