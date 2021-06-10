package com.jack.review.test.DesignPatterns.creational.factory.byEnum;

import com.jack.review.test.DesignPatterns.creational.factory.Food;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/14:52
 */
public class MainClass {
    public static void main(String[] args) {
        Food foodA = ChineseFoodFactory.A.makeFood();
        Food foodB = ChineseFoodFactory.valueOf("B").makeFood();
    }
}
