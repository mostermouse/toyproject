package com.toyproject.toyproject.beanfind;

import com.toyproject.toyproject.config.AppConfig;
import com.toyproject.toyproject.member.Member;
import com.toyproject.toyproject.service.MemberService;
import com.toyproject.toyproject.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AplicationContextBasciFindTest {
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("bean name find")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService" , MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("bean name type")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("bean name not found")
    void findBeanNameX(){
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class ,
        () -> ac.getBean("xxxxx" , MemberService.class));
    }

}
