package com.jack.review.test.DesignPatterns.structural.adapter.objectAdapter;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/10:29
 */
public class SomeAdapter implements Target {
    private Something something = new Something();

    @Override
    public void method1() {
        System.out.println("自己实现method1");
    }

    @Override
    public void method2() {
        something.method2();
    }

    @Override
    public void method3() {
        something.method3();
    }
}
