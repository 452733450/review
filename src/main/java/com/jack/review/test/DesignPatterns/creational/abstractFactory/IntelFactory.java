package com.jack.review.test.DesignPatterns.creational.abstractFactory;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/18:18
 */
public class IntelFactory extends ComputerFactory {
    @Override
    CPU makeCPU() {
        return new IntelCPU();
    }

    @Override
    MainBoard makeMainBoard() {
        return new IntelMainBoard();
    }
}
