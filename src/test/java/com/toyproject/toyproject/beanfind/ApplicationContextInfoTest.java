package com.toyproject.toyproject.beanfind;

import com.toyproject.toyproject.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("全てのBean出力")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object object = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object =" + object);
        }
    }

    @Test
    @DisplayName("Application Bean 出力")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition =ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object object = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object =" + object);
            }
        }
    }


}
