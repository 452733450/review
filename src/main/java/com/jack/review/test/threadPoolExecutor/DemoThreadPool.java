package com.jack.review.test.threadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/02/19/15:39
 */
public class DemoThreadPool {
    BlockingQueue<Runnable> taskQueue;
    List<DemoThread> threads;

    DemoThreadPool(BlockingQueue<Runnable> taskQueue, int threadsSize) {
        this.taskQueue = taskQueue;
        for (int i = 0; i < threadsSize; i++) {
            threads = new ArrayList<>(threadsSize);
            DemoThread thread = new DemoThread("线程" + i);
            thread.start();
            threads.add(thread);
        }
    }

    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DemoThreadPool demoThreadPool = new DemoThreadPool(new LinkedBlockingQueue<>(5), 5);
        for (int i = 0; i < 10; i++) {
            demoThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "做任务了");
            });
        }
    }


    class DemoThread extends Thread {
        DemoThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
