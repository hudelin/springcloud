package com.hu.pattern.structural.filter;

import java.util.List;

/**
 * @author : hudelin
 * @className :AndCriteria
 * @description : 交集标准
 * @date: 2020-07-17 10:23
 */
public class AndCriteria implements Criteria  {

    private Criteria criteria;

    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaPersonList = criteria.meetCriteria(personList);
        return otherCriteria.meetCriteria(firstCriteriaPersonList);
    }
}
