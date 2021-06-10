package com.jack.review.test.DesignPatterns.creational.simpleFactory;

import com.jack.review.test.DesignPatterns.creational.factory.Food;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/17:40
 */
public class LanZhouNoodle extends Food {

    public void addSpicy(String spicy) {
        if ("more".equals(spicy)) {
            System.out.println("多加点辣");
        }
    }
}
