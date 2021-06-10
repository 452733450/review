package com.jack.review.test.DesignPatterns.structural.adapter;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/10:03
 */
public class WildCock implements Cock{
    @Override
    public void gobble() {
        System.out.println("咕咕叫");
    }

    @Override
    public void fly() {
        System.out.println("鸡也会飞哦");
    }
}
