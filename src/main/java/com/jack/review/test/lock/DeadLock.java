package com.jack.review.test.lock;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/22/11:06
 */
public class DeadLock {
    public static String str1 = "str1";
    public static String str2 = "str2";

    public static void main(String[] args){
        Thread a = new Thread(() -> {
            try{
                while(true){
                    synchronized(DeadLock.str1){
                        System.out.println(Thread.currentThread().getName()+"锁住 str1");
                        Thread.sleep(1000);
                        synchronized(DeadLock.str2){
                            System.out.println(Thread.currentThread().getName()+"锁住 str2");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try{
                while(true){
                    synchronized(DeadLock.str2){
                        System.out.println(Thread.currentThread().getName()+"锁住 str2");
                        Thread.sleep(1000);
                        synchronized(DeadLock.str1){
                            System.out.println(Thread.currentThread().getName()+"锁住 str1");
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
    }
}
