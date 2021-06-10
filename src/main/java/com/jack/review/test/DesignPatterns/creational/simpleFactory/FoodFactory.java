package com.jack.review.test.DesignPatterns.creational.simpleFactory;

import com.jack.review.test.DesignPatterns.creational.factory.Food;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/17:39
 */
public class FoodFactory {
    public static Food makeFood(String name) {
        if (name.equals("noodle")) {
            System.out.println("吃面");
            Food noodle = new LanZhouNoodle();
            noodle.addSpicy("more");
            return noodle;
        } else if (name.equals("chicken")) {
            System.out.println("吃黄焖鸡");
            Food chicken = new HuangMenChicken();
            chicken.addCondiment("potato");
            return chicken;
        } else {
            return null;
        }
    }
}
