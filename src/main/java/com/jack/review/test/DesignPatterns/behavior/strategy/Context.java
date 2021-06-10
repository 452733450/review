package com.jack.review.test.DesignPatterns.behavior.strategy;

/**
 * @Description: 使用策略的类
 * @Auther: Jack You
 * @Date: 2021/05/25/16:42
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeDraw(int radius, int x, int y) {
        strategy.draw(radius, x, y);
    }
}
