package com.jack.review.test.DesignPatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/14:27
 */
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates; // 下属

    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    /*public String toString(){
        return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
    }*/

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", subordinates=" + subordinates +
                '}';
    }
}
