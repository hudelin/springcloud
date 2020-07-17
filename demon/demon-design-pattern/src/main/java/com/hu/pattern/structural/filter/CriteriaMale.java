package com.hu.pattern.structural.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : hudelin
 * @className :CriteriaMale
 * @description : 男性标准
 * @date: 2020-07-17 10:18
 */
public class CriteriaMale implements  Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> malePersonList = personList.stream()
                .filter(person -> ("MALE".equals(person.getGender())))
                .collect(Collectors.toList());
        return malePersonList;
    }
}
