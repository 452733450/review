package com.jack.review.test.DesignPatterns.creational.abstractFactory;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/18:19
 */
public class AmdFactory extends ComputerFactory{
    @Override
    CPU makeCPU() {
        return new AmdCPU();
    }

    @Override
    MainBoard makeMainBoard() {
        return new AmdMainBoard();
    }
}
