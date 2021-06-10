package com.jack.review.test.DesignPatterns.structural.adapter.objectAdapter;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/10:31
 */
public class MainClass {
    public static void main(String[] args) {
        Target target = new SomeAdapter();
        target.method1();
        target.method2();
        target.method3();
    }
}
