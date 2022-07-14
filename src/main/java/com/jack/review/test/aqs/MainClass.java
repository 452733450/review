package com.jack.review.test.aqs;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
        try {
            // 每个 condition 有一个关联的条件队列，
            // 如线程 1 调用 condition1.await() 方法即可将当前线程 1 包装成 Node 后加入到条件队列中，
            // 然后阻塞在这里，不继续往下执行，条件队列是一个单向链表；
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 调用condition1.signal() 触发一次唤醒，
        // 此时唤醒的是队头，会将condition1 对应的条件队列的 firstWaiter（队头） 移到阻塞队列的队尾，
        // 等待获取锁，获取锁后 await 方法才能返回，继续往下执行。
        condition1.signal();

        Semaphore semaphore = new Semaphore(2);
    }
}
