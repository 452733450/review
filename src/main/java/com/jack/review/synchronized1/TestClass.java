package com.jack.review.synchronized1;

public class TestClass {

    //共享资源(临界资源)
    static int i=0;

    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }

    /**
     * 作用于静态方法,锁是当前class对象,也就是
     * AccountingSyncClass类对应的class对象
     */
    public static synchronized void increase2(){
        i++;
    }

    //this,当前实例对象
    public void test(){
        synchronized(this){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }

        //class对象锁
        synchronized(TestClass.class){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }
    }

}
