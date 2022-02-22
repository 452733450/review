package com.jack.review.test.lock;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/02/22/14:49
 */
public class DeadLockDemo {
    final Object o1 = new Object();
    final Object o2 = new Object();

    private void test() {
        Thread a = new Thread(() -> {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "锁住o1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "锁住o2");
                }
            }
        });


        Thread b = new Thread(() -> {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "锁住o2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "锁住o1");
                }
            }
        });
        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().test();
    }

}
