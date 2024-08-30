package com.toyproject.toyproject.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean1.class);
        PrototypeBean1 prototypeBean1 = ac.getBean(PrototypeBean1.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean1 prototypeBean2 = ac.getBean(PrototypeBean1.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);


    }
    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean1.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(2);


    }
    @Scope("singleton")
    static class ClientBean{
        private final PrototypeBean1 prototypeBean1;

        @Autowired
        public ClientBean(PrototypeBean1 prototypeBean1) {
            this.prototypeBean1 = prototypeBean1;
        }
        public int logic(){
            prototypeBean1.addCount();
            int count = prototypeBean1.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean1 {
        private int count = 0;

        public void addCount(){
            count++;
        }
        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("Prototype.init" + this);
        }

        @PreDestroy
        public void destory(){
            System.out.println("Prototype.destory");
        }


    }
}
