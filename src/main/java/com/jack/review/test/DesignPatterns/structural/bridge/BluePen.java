package com.jack.review.test.DesignPatterns.structural.bridge;

/**
 * @Description: 策略
 * @Auther: Jack You
 * @Date: 2021/05/25/16:41
 */
public class BluePen implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用蓝色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
