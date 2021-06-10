package com.jack.review.test.DesignPatterns.creational.factory;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/17:25
 */
public class AmericanFoodFactory implements FoodFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")) {
            return new AmericanFoodA();
        } else if (name.equals("B")) {
            return new AmericanFoodB();
        } else {
            return null;
        }
    }
}
