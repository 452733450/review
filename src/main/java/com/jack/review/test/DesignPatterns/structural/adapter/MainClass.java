package com.jack.review.test.DesignPatterns.structural.adapter;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/10:05
 */
public class MainClass {
    public static void main(String[] args) {
        // 有一只野鸡
        Cock wildCock = new WildCock();
        // 成功将野鸡适配成鸭
        Duck duck = new CockAdapter(wildCock);
        duck.quack();
        duck.fly();
    }
}
