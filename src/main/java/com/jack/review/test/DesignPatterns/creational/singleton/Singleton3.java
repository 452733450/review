package com.jack.review.test.DesignPatterns.creational.singleton;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/26/13:26
 */
public class Singleton3 {
    private Singleton3(){

    }
    private static class Holder {
        private static final Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return Holder.instance;
    }
}
