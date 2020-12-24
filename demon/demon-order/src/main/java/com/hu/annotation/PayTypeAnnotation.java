package com.hu.annotation;


import com.hu.constant.PayTypeEnum;

import java.lang.annotation.*;

/**
 * @author hudelin
 * @date 2020-12-04
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PayTypeAnnotation {

    PayTypeEnum value();
}
