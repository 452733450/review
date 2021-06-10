package com.jack.review.test.DesignPatterns.structural.bridge;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/25/16:58
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void executeDraw();
}
