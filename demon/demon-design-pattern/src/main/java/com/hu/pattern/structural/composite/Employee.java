package com.hu.pattern.structural.composite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : hudelin
 * @className :Employee
 * @description :员工，组合模式
 * @date: 2020-07-17 10:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    /**
     * 姓名
     */
    private String name;

    /**
     * 部门
     */
    private String dept;

    /**
     * 工资
     */
    private BigDecimal salary;

    /**
     * 下属
     */
    private List<Employee> subordinateList;

    public void add(Employee employee) {
        subordinateList.add(employee);
    }

    public void remove(Employee employee) {
        subordinateList.remove(employee);
    }

    public static void main(String[] args) {
        Employee CEO = Employee.builder()
                .name("胡德霖").dept("CEO").salary(BigDecimal.valueOf(30000)).subordinateList(new ArrayList<>())
                .build();
        Employee headSale = Employee.builder()
                .name("福德宁销售").dept("HEAD_SALE").salary(BigDecimal.valueOf(20000)).subordinateList(new ArrayList<>())
                .build();
        Employee headMarketing = Employee.builder()
                .name("福德宁营销").dept("HEAD_MARKETING").salary(BigDecimal.valueOf(20000)).subordinateList(new ArrayList<>())
                .build();
        Employee sale1 = Employee.builder()
                .name("福德宁销售小弟1").dept("SALE").salary(BigDecimal.valueOf(10000)).subordinateList(new ArrayList<>())
                .build();
        Employee sale2 = Employee.builder()
                .name("福德宁销售小弟2").dept("SALE").salary(BigDecimal.valueOf(10000)).subordinateList(new ArrayList<>())
                .build();
        Employee marketing1 = Employee.builder()
                .name("福德宁营销小弟1").dept("MARKETING").salary(BigDecimal.valueOf(10000)).subordinateList(new ArrayList<>())
                .build();
        Employee marketing2 = Employee.builder()
                .name("福德宁营销小弟2").dept("MARKETING").salary(BigDecimal.valueOf(10000)).subordinateList(new ArrayList<>())
                .build();

        CEO.add(headSale);
        CEO.add(headMarketing);

        headSale.add(sale1);
        headSale.add(sale2);

        headMarketing.add(marketing1);
        headMarketing.add(marketing2);

        System.out.println(CEO);

    }

}
