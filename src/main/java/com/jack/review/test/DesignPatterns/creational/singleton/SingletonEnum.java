package com.jack.review.test.DesignPatterns.creational.singleton;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/11/23/14:55
 */
public enum  SingletonEnum {
    INSTANCE;
    public SingletonEnum getInstance(){
        return INSTANCE;
    }
}
