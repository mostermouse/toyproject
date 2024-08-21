package com.toyproject.toyproject.discount;

import com.toyproject.toyproject.member.Grade;
import com.toyproject.toyproject.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIPは　10％割引する")
    void vip_o(){
        //given
        Member member = new Member(1L , "memberVIP" , Grade.VIP);
        //when
        int discount = discountPolicy.discount(member , 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIPじゃないと割引できない")
    void vip_x(){
        //given
        Member member = new Member(2L , "memberBasic" , Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member , 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
