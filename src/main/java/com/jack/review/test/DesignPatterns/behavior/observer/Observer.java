package com.jack.review.test.DesignPatterns.behavior.observer;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/28/14:54
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
