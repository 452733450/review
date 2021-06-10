package com.jack.review.test.DesignPatterns.structural.decorator;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/13:52
 */
public class Mango extends Beverage{
    private Beverage beverage;

    public Mango(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 加芒果3元";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3; // 加芒果需要 3 元
    }
}
