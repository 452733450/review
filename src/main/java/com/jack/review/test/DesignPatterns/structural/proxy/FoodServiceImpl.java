package com.jack.review.test.DesignPatterns.structural.proxy;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/9:23
 */
public class FoodServiceImpl implements FoodService{
    @Override
    public Food makeChicken() {
        Food f = new Chicken();
        f.setChicken("1kg");
        f.setSpicy("1g");
        f.setSalt("3g");
        return f;
    }

    @Override
    public Food makeNoodle() {
        Food f = new Noodle();
        f.setNoodle("500g");
        f.setSalt("5g");
        return f;
    }
}
