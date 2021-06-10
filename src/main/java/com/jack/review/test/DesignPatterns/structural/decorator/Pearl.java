package com.jack.review.test.DesignPatterns.structural.decorator;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/13:52
 */
public class Pearl extends Beverage{
    private Beverage beverage;

    public Pearl(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 加珍珠4元";
    }

    @Override
    public double cost() {
        return beverage.cost() + 4; // 加珍珠需要 4 元
    }
}
