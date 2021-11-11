package com.jack.review.test.function;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/29/13:10
 */
public class RunnableDemo {
    public static void main(String[] args) {
        //在主方法中调用startThread方法
        //匿名内部类的方式
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程启动了");
            }
        });
        //Lambda方式
        startThread(() -> System.out.println(Thread.currentThread().getName() + "线 程启动了"));
    }

    private static void startThread(Runnable r) {
        new Thread(r).start();
    }
}
