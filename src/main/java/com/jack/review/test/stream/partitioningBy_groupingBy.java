package com.jack.review.test.stream;

import com.jack.review.util.ModelUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/11/14:21
 */
public class partitioningBy_groupingBy {
    /*partitioningBy 分区：将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分。
    groupingBy 分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组*/
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 1, "male", "New York"));
        personList.add(new Person("Jack", 7000, 1, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 1, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 1, "female", "New York"));
        personList.add(new Person("Owen", 9500, 1, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 1, "female", "New York"));
        personList.add(new Person("Alisa", 7900, 1, "male", "New York"));

        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组

        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);
        Map<String,List<Person>> map = ModelUtils.groupToMap(personList,e->e.getName()+ "-" +e.getSex());
        System.out.println(map.size());
    }
}
