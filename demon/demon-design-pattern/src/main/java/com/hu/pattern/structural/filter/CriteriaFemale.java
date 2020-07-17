package com.hu.pattern.structural.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : hudelin
 * @className :CriteriaFemale
 * @description : 女性标准
 * @date: 2020-07-17 10:21
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> femalePersonList = personList.stream()
                .filter(person -> ("FEMALE".equals(person.getGender())))
                .collect(Collectors.toList());
        return femalePersonList;
    }
}
