package com.jack.review.test.DesignPatterns.structural.composite;

/**
 * @Description: 组合模式用于表示具有层次结构的数据，使得我们对单个对象和组合对象的访问具有一致性
 * @Auther: Jack You
 * @Date: 2021/05/31/14:30
 */
public class MainClass {
    public static void main(String[] args) {
        Employee employee = new Employee("Jack", "Java", 10);
        employee.add(new Employee("Perter", "java", 1));

        System.out.println(employee.toString());
        System.out.println(employee.getSubordinates());
    }
}
