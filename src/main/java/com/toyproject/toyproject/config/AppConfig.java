package com.toyproject.toyproject.config;

import com.toyproject.toyproject.Repository.MemberRepository;
import com.toyproject.toyproject.Repository.MemoryMemberRepository;
import com.toyproject.toyproject.discount.DiscountPolicy;
import com.toyproject.toyproject.discount.FixDiscountPolicy;
import com.toyproject.toyproject.discount.RateDiscountPolicy;
import com.toyproject.toyproject.order.OrderService;
import com.toyproject.toyproject.order.OrderServiceImpl;
import com.toyproject.toyproject.service.MemberService;
import com.toyproject.toyproject.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//빈등록하면 항상 싱글톤을 보장하는 것이 아니기 때문에 달면 항상 보장 됨
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository() , discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
