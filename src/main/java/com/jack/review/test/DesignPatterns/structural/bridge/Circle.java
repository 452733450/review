package com.jack.review.test.DesignPatterns.structural.bridge;

/**
 * @Description: 圆形
 * @Auther: Jack You
 * @Date: 2021/05/25/17:01
 */
public class Circle extends Shape{

    private int radius;

    public Circle(DrawAPI drawAPI, int radius) {
        super(drawAPI);
        this.radius = radius;
    }

    @Override
    public void executeDraw() {
        drawAPI.draw(radius,0, 0);
    }


}
