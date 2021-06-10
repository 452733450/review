package com.jack.review.test.threadLocal;

/**
 * @Description: 实现原理
 * @Auther: Jack You
 * @Date: 2021/05/25/10:18
 * @see: https://mp.weixin.qq.com/s/XXtjJF7jMKs9S5TCplKhvw
 */
public class implement {
    // ThreadLocal 主要用来做线程变量的隔离
    public static void main(String[] args) {

    }

    private static void test(){
        ThreadLocal<User> threadLocal = new ThreadLocal<>();
        User user = User.builder().username("test").age(1).build();
        threadLocal.set(user);
    }
}
