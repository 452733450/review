package com.jack.review.test.DesignPatterns.structural.facade;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/14:21
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
