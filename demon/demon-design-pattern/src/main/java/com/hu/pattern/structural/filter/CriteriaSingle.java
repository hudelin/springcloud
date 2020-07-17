package com.hu.pattern.structural.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : hudelin
 * @className :CriteriaSingle
 * @description : 单身标准
 * @date: 2020-07-17 10:22
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> singlePersonList = personList.stream()
                .filter(person -> ("SINGLE".equals(person.getMaritalStatus())))
                .collect(Collectors.toList());
        return singlePersonList;

    }
}
