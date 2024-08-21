package com.toyproject.toyproject.order;

import com.toyproject.toyproject.config.AppConfig;
import com.toyproject.toyproject.member.Grade;
import com.toyproject.toyproject.member.Member;
import com.toyproject.toyproject.service.MemberService;
import com.toyproject.toyproject.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId , "meberA" , Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA" , 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
