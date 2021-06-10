package com.jack.review.test.DesignPatterns.creational.simpleFactory;

import com.jack.review.test.DesignPatterns.creational.factory.Food;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/17:40
 */
public class HuangMenChicken extends Food {
    public void addCondiment(String str) {
        if ("potato".equals(str)) {
            System.out.println("多加点土豆");
        }
    }
}
