package com.hu.pattern.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hudelin
 * @className :OrCriteria
 * @description : 并集标准，过滤器模式或标准模式，属于结构型模式
 * @date: 2020-07-17 10:27
 */
public class OrCriteria implements Criteria {

    private Criteria criteria;

    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaPersonList = criteria.meetCriteria(personList);
        List<Person> otherCriteriaPersonList = otherCriteria.meetCriteria(personList);

        otherCriteriaPersonList.stream().forEach(person -> {
            if (firstCriteriaPersonList.contains(person)) {
                firstCriteriaPersonList.add(person);
            }
        });

        return firstCriteriaPersonList;
    }

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().name("小明").gender("MALE").maritalStatus("SINGLE").build());
        personList.add(Person.builder().name("小王").gender("MALE").maritalStatus("MARRIED").build());
        personList.add(Person.builder().name("小红").gender("FEMALE").maritalStatus("MARRIED").build());
        personList.add(Person.builder().name("小美").gender("FEMALE").maritalStatus("SINGLE").build());
        personList.add(Person.builder().name("小黑").gender("MALE").maritalStatus("SINGLE").build());
        personList.add(Person.builder().name("小白").gender("MALE").maritalStatus("SINGLE").build());

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("男性：");
        System.out.println(male.meetCriteria(personList));
        System.out.println("女性：");
        System.out.println(female.meetCriteria(personList));
        System.out.println("单身男性：");
        System.out.println(singleMale.meetCriteria(personList));
        System.out.println("单身或者女性：");
        System.out.println(singleOrFemale.meetCriteria(personList));

    }
}
/**
 * 意图：将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
 *
 * 主要解决：它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，客户程序可以像处理简单元素一样来处理复杂元素，从而使得客户程序与复杂元素的内部结构解耦。
 *
 * 何时使用： 1、您想表示对象的部分-整体层次结构（树形结构）。 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 *
 * 如何解决：树枝和叶子实现统一接口，树枝内部组合该接口。
 *
 * 关键代码：树枝内部组合该接口，并且含有内部属性 List，里面放 Component。
 *
 * 应用实例： 1、算术表达式包括操作数、操作符和另一个操作数，其中，另一个操作符也可以是操作数、操作符和另一个操作数。 2、在 JAVA AWT 和 SWING 中，对于 Button 和 Checkbox 是树叶，Container 是树枝。
 *
 * 优点： 1、高层模块调用简单。 2、节点自由增加。
 *
 * 缺点：在使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则。
 *
 * 使用场景：部分、整体场景，如树形菜单，文件、文件夹的管理。
 *
 * 注意事项：定义时为具体类。
 */
