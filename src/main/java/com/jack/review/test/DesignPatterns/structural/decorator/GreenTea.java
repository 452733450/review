package com.jack.review.test.DesignPatterns.structural.decorator;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/13:49
 */
public class GreenTea extends Beverage{
    @Override
    public String getDescription() {
        return "绿茶11块";
    }

    @Override
    public double cost() {
        return 11;
    }
}
