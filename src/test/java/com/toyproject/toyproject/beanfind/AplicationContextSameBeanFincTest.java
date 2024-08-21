package com.toyproject.toyproject.beanfind;

import com.toyproject.toyproject.Repository.MemberRepository;
import com.toyproject.toyproject.Repository.MemoryMemberRepository;
import com.toyproject.toyproject.config.AppConfig;
import com.toyproject.toyproject.discount.DiscountPolicy;
import com.toyproject.toyproject.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class AplicationContextSameBeanFincTest {
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(SameBeanConfig.class);


    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 중복오류")
    void findByTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class , () ->
                ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 이름 지정 해두면 됨")
    void findBeanByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(memberRepository)
                .isInstanceOf(MemberRepository.class);
    }
    @Test
    @DisplayName("特定のType全て参照")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("keys :" + key + "value" + beansOfType.get(key));
        }
        System.out.println("beansoftype :" + beansOfType);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);

    }

    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
