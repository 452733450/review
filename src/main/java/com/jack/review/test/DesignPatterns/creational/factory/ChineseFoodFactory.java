package com.jack.review.test.DesignPatterns.creational.factory;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/17:25
 */
public class ChineseFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new ChineseFoodA();
        } else if (name.equals("B")) {
            return new ChineseFoodB();
        } else {
            return null;
        }
    }
}
