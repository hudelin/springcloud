package com.hu.pattern.structural.filter;

import java.util.List;

/**
 * @author : hudelin
 * @className :Criteria
 * @description : 标准
 * @date: 2020-07-17 10:15
 */
public interface Criteria {

    /**
     * 符合标准
     * @param personList
     * @return
     */
    List<Person> meetCriteria(List<Person> personList);
}
