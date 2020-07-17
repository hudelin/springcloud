package com.hu.pattern.structural.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : hudelin
 * @className :Person
 * @description : 人
 * @date: 2020-07-17 10:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别：MALE,FEMALE
     */
    private String gender;

    /**
     * 婚姻状态：SINGLE,MARRIED
     */
    private String maritalStatus;
}
