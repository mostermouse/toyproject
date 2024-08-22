package com.toyproject.toyproject.singleton;

import com.toyproject.toyproject.config.AppConfig;
import com.toyproject.toyproject.service.MemberService;
import com.toyproject.toyproject.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonContainerTest {
    @Test
    @DisplayName("spring container and singleton")
    void springContainer(){
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService" , MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberSerivce1 :" + memberService1);
        System.out.println("memberService2 :" + memberService2);
        //memberSerivce1 :com.toyproject.toyproject.service.MemberServiceImpl@452e26d0
        //memberService2 :com.toyproject.toyproject.service.MemberServiceImpl@452e26d0

        Assertions.assertThat(memberService1).isSameAs(memberService2);



    }
}
