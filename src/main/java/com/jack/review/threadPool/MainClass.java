package com.jack.review.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/27/15:07
 */
public class MainClass {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,100, TimeUnit.SECONDS, null);
        /*threadPoolExecutor.execute();*/
    }
}
