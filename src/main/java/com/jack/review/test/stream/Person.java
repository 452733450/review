package com.jack.review.test.stream;

import lombok.Data;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/11/14:23
 */
@Data
public class Person {
    private String name;
    private Integer salary;
    private Integer age;
    private String sex;
    private String area;

    public Person(String name, Integer salary, Integer age, String sex, String city) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


}
