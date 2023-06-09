package com.jack.questions.basics.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {

    }

    class Counter {
        //使用AtomicInteger之后，不需要加锁，也可以实现线程安全。
        private AtomicInteger count = new AtomicInteger();

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }
}
