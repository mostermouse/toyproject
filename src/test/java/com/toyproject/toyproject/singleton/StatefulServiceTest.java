package com.toyproject.toyproject.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        //ThreadA   A사용자 10000원 주문
        int userAprice = statefulService1.order("UserA" , 10000);
        //ThreadB   B사용자 20000원 주문
        int userBprice = statefulService2.order("UserB" , 20000);
        //
       // int price = statefulService1.getPrice();
        System.out.println("price = " + userAprice);
        System.out.println("price = " + userBprice);
        Assertions.assertThat(userAprice).isEqualTo(10000);
        Assertions.assertThat(userBprice).isEqualTo(20000);

    }

    @Configuration
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
