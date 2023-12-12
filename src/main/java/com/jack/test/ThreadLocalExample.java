package com.jack.test;

public class ThreadLocalExample {
    // 定义一个ThreadLocal变量
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 在父线程中设置ThreadLocal变量的值
        threadLocal.set("Hello from parent thread");

        // 创建一个子线程
        Thread childThread = new Thread(() -> {
            // 在子线程中获取ThreadLocal变量的值
            String value = threadLocal.get();
            System.out.println("Value in child thread: " + value);
        });

        // 启动子线程
        childThread.start();

        try {
            // 等待子线程执行完成
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 在父线程中获取ThreadLocal变量的值
        String valueInParent = threadLocal.get();
        System.out.println("Value in parent thread: " + valueInParent);
    }
}

