package com.jack.review.test.DesignPatterns.creational.singleton;

import java.util.Date;

/**
 * @Description: 懒汉
 * @Auther: Jack You
 * @Date: 2021/05/25/18:03
 */
public class Singleton_hungry {
    private Singleton_hungry() {
    }

    // 首先，将 new Singleton() 堵死
    private static Singleton_hungry singleton = new Singleton_hungry();

    // 创建私有静态实例，意味着这个类第一次使用的时候就会进行创建
    public static Singleton_hungry getInstance() {
        return singleton;
    }

    // 瞎写一个静态方法。这里想说的是，如果我们只是要调用 Singleton.getDate(...)，
    // 本来是不想要生成 Singleton 实例的，不过没办法，已经生成了
    public static Date getDate(String mode) {
        return new Date();
    }
}
