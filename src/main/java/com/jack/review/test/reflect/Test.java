package com.jack.review.test.reflect;

import lombok.Data;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/01/15:31
 */
@Data
public class Test {
    private int age;
    private String name;
    private int testInt;

    public Test() {

    }

    public Test(String name) {
        this.name = name;
        System.out.println("My Name is" + name);
    }

    public Test(int age) {
        this.age = age;
        System.out.println("My age is" + age);
    }

    private Test(int age, String name, int testInt) {
        this.age = age;
        this.name = name;
        this.testInt = testInt;
        System.out.println("hello" + name + "i am" + age);
    }

    private void welcome(String tips) {
        System.out.println("我是welcome方法,参数是：" + tips);
    }
}
