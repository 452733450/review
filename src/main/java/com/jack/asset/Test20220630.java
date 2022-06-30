package com.jack.asset;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/06/30/14:06
 */
public class Test20220630 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("获取了锁");
                try {
                    System.out.println("休眠一会儿");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("调用wait..");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("被唤醒");
            }
        }, "A");
        threadA.start();

        lock.notify();

    }
}
