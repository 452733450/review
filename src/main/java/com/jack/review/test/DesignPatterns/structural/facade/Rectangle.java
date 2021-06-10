package com.jack.review.test.DesignPatterns.structural.facade;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/14:20
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
