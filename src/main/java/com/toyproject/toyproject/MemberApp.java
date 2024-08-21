package com.toyproject.toyproject;

import com.toyproject.toyproject.config.AppConfig;
import com.toyproject.toyproject.member.Grade;
import com.toyproject.toyproject.member.Member;
import com.toyproject.toyproject.service.MemberService;
import com.toyproject.toyproject.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService" , MemberService.class);



        Member member = new Member(1L , "memberA" , Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member :"  + member.getName());
        System.out.println("find Member :"  + findMember.getName());




    }
}
