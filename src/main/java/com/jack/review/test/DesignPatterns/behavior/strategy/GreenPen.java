package com.jack.review.test.DesignPatterns.behavior.strategy;

/**
 * @Description: 策略
 * @Auther: Jack You
 * @Date: 2021/05/25/16:40
 */
public class GreenPen implements Strategy{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用绿色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
