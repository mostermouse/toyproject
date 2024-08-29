package com.toyproject.toyproject.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;
import java.lang.reflect.Type;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
