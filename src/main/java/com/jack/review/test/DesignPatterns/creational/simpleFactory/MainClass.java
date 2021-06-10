package com.jack.review.test.DesignPatterns.creational.simpleFactory;

/**
 * @Description: 简单工厂模式
 * @Auther: Jack You
 * @Date: 2021/05/28/17:47
 */
public class MainClass {
    /*简单地说，简单工厂模式通常就是这样，一个工厂类 XxxFactory，里面有一个静态方法，
    根据我们不同的参数，返回不同的派生自同一个父类（或实现同一接口）的实例对象。*/
    public static void main(String[] args) {
        FoodFactory.makeFood("noodle");
        FoodFactory.makeFood("chicken");
    }
}
