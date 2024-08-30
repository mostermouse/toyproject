package com.toyproject.toyproject.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {
    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean pro1 = ac.getBean(PrototypeBean.class);
        PrototypeBean pro2 = ac.getBean(PrototypeBean.class);
        System.out.println("pro1 = " + pro1);
        System.out.println("pro2 = " + pro2);
        Assertions.assertThat(pro1).isNotSameAs(pro2);
        ac.close();

        //prototype은 조회할때 생성되고 버림 그래서 초기화만 하고 종료 메서드가 실행 안됨
    }
    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("prototypeBean init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("prototypeBean destroy");
        }
    }
}
