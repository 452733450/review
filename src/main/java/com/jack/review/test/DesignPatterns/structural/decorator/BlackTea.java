package com.jack.review.test.DesignPatterns.structural.decorator;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/13:47
 */
public class BlackTea extends Beverage{
    @Override
    public String getDescription() {
        return "红茶10块";
    }

    @Override
    public double cost() {
        return 10;
    }
}
