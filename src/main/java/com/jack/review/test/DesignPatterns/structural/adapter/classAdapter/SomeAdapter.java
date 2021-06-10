package com.jack.review.test.DesignPatterns.structural.adapter.classAdapter;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/11:26
 */
public class SomeAdapter extends Something implements Target{

    @Override
    public void method1() {
        System.out.println("自己实现method1");
    }


    public void method2() {
        super.method2();
    }


    public void method3() {
        super.method3();
    }


}
