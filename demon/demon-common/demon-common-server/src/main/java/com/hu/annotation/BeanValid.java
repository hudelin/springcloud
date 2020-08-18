package com.hu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : hudelin
 * @className :BeanValid
 * @description : bean校验注解
 * @date: 2020-07-08 17:34
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BeanValid {

    Class<?>[] value() default {};
}
