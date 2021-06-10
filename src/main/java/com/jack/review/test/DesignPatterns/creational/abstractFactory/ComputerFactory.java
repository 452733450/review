package com.jack.review.test.DesignPatterns.creational.abstractFactory;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/18:13
 */
public abstract class ComputerFactory {
    abstract CPU makeCPU();
    abstract MainBoard makeMainBoard();
}
