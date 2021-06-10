package com.jack.review.test.DesignPatterns.structural.facade;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/14:20
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
