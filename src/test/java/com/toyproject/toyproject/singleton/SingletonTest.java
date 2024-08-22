package com.toyproject.toyproject.singleton;

import com.toyproject.toyproject.config.AppConfig;
import com.toyproject.toyproject.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("springがない純粋なDIコンテナ")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1.조회 : 호출할 때 마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        System.out.println("memberService1 :" + memberService1);
        System.out.println("memberService2 :" + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴 테스트")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 :" + singletonService1);
        System.out.println("singletonService2 :" + singletonService2);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);


    }
}
