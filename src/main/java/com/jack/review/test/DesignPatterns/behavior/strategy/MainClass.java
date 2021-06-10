package com.jack.review.test.DesignPatterns.behavior.strategy;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/25/16:47
 */
public class MainClass {
    public static void main(String[] args) {
        Context context = new Context(new RedPen());
        context.executeDraw(1, 2, 3);

        Context context1 = new Context(new GreenPen());
        context1.executeDraw(3, 4, 5);

        Context context2 = new Context(new BluePen());
        context2.executeDraw(6, 7, 8);
    }
}
