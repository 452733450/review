package com.jack.review.test.threadLocal;

/**
 * @Description: 实现原理
 * @Auther: Jack You
 * @Date: 2021/05/25/10:18
 * @see: https://mp.weixin.qq.com/s/XXtjJF7jMKs9S5TCplKhvw
 */
public class implement {
    static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();
    // ThreadLocal 主要用来做线程变量的隔离

    public static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"java金融");
    public static void main(String[] args) {
        /*System.out.println(threadLocal.get());
        Thread t = new Thread();
        threadLocal.remove();*/
        Thread t1 = new Thread(() -> {
            System.out.println("获取初始值："+threadLocal.get());
            threadLocal.set("关注：【java金融】");
            System.out.println("获取修改后的值："+threadLocal.get());
            threadLocal.remove();
            System.out.println("-----------------");
        });
        t1.start();

        Thread t2 = new Thread(()->{
            System.out.println("获取初始值："+threadLocal.get());
            threadLocal.set("关注：【java科技】");
            System.out.println("获取修改后的值："+threadLocal.get());
            threadLocal.remove();
        });
        t2.start();
    }

    private static void test(){
        User user = User.builder().username("test").age(1).build();
        /*ThreadLocal.ThreadLocalMap.Entry[] tab = table;
        int len = tab.length;
        int i = key.threadLocalHashCode & (len-1);
        hashcode & 操作其实就是 %数组长度取余数，例如：数组长度是4，hashCode % (4-1) 就找到要存放元素的数组下标*/
        userThreadLocal.set(user);
    }
}
