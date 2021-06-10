package com.jack.review.test.DesignPatterns.structural.bridge;


/**
 * @Description: 将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 * @Auther: Jack You
 * @Date: 2021/05/25/17:10
 */
public class MainClass {
    public static void main(String[] args) {
        Shape circle = new Circle(new RedPen(),1);
        circle.executeDraw();

        Shape rectangle = new Rectangle(new BluePen(),3,2);
        rectangle.executeDraw();

        Shape square = new Square(new GreenPen(), 4, 4);
        square.executeDraw();
    }
}
