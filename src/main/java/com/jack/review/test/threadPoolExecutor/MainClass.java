package com.jack.review.test.threadPoolExecutor;

import cn.hutool.core.thread.FinalizableDelegatedExecutorService;
import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.*;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/25/9:39
 */
public class MainClass {

    /*public ThreadPoolExecutor(int corePoolSize, 核心线程数
                              int maximumPoolSize, 最大线程数
                              long keepAliveTime, 超过核心数的线程空闲时间，空太久了就销毁
                              TimeUnit unit, 时间单位
                              BlockingQueue<Runnable> workQueue, 工作队列，就是放任务的
                              RejectedExecutionHandler handler) { 拒绝策略
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                Executors.defaultThreadFactory(), handler);*/

        /*ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();*/
    /*ThreadPoolExecutor threadPoolExecutor = new org.apache.tomcat.util.threads.ThreadPoolExecutor()*/

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new NamedThreadFactory("my-task-pool", false),
                new ThreadPoolExecutor.DiscardOldestPolicy());


            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName()+" run task...");
            });
        threadPoolExecutor.shutdown();


    }

    /*FixedThreadPool
    创建线程数量固定的线程池。核心线程数等于最大线程数，空闲时间为0，由于没有核心线程以外的线程，因此空闲时间不再起作用。不过可以使用allowCoreThreadTimeOut(true)来设置核心线程的销毁策略。
    等待队列使用的是没有指定容量的LinkedBlockingQueue，该队列默认容量是Integer.MAX_VALUE。因此可能会堆积大量的请求，从而导致OOM。*/
    public static ExecutorService newFixedThreadPool(int nThreads){
        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    /*SingleThreadExecutor
    创建一个单线程的线程池。和上面的FixedThreadPool区别在于指定了线程数量为1。也存在队列溢出风险*/
    public static ExecutorService newSingleThreadExecutor() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    /*CachedThreadPool
    可以进行缓存的线程池。核心线程数为0，最大线程数为Integer.MAX_VALUE。意味着它的线程数可以按需任意增加。
    提交任务时会优先复用先前已经创建好的线程来执行。如果没有可用的线程将创建新的线程来执行任务。60秒内未使用的线程将被终止并从缓存中删除。因此这种保持一定空闲时间的线程缓存池不会消耗任何额外资源。但是某些业务场景下可能会导致创建大量的线程，从而导致OOM。*/
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }

    /*ScheduledThreadPool
    创建一个可以执行延迟任务或者定期任务的线程池，就是在给定的延迟时间之后，或周期性地执行任务。类似于Timer定时器，但是比后者更好用。*/
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }


}
