package com.jack.review.test.DesignPatterns.structural.bridge;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/25/17:22
 */
public class Rectangle extends Shape {
    private int x;
    private int y;

    public Rectangle(DrawAPI drawAPI, int x, int y) {
        super(drawAPI);
        this.x = x;
        this.y = y;
    }

    @Override
    public void executeDraw() {
        drawAPI.draw(0, x, y);
    }
}
