package com.jack.questions.basics.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/11/02/14:05
 */
public class Counter {
    //使用AtomicInteger之后，不需要加锁，也可以实现线程安全。
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
