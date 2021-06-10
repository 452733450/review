package com.jack.review.test.DesignPatterns.creational.singleton;

import java.util.Date;

/**
 * @Description: 饱汉
 * @Auther: Jack You
 * @Date: 2021/05/25/18:03
 */
public class Singleton_lazy {
    // 首先，也是先堵死 new Singleton() 这条路
    private Singleton_lazy() {
    }

    // 和饿汉模式相比，这边不需要先实例化出来，注意这里的 volatile，它是必须的
    private static volatile Singleton_lazy instance = null;

    private static Singleton_lazy getInstance() {
        if (instance == null) {
            // 加锁
            synchronized (Singleton_lazy.class) {
                // 这一次判断也是必须的，不然会有并发问题
                if (instance == null) {
                    instance = new Singleton_lazy();
                }
            }
        }

        return instance;
    }
}
