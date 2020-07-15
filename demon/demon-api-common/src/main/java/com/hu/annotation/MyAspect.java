package com.hu.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author : hudelin
 * @className :MyAspect
 * @description :
 * @date: 2020-07-14 16:56
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@IgnoreTokenAuth
public @interface MyAspect {

}
