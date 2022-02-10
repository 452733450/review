//package com.jack.review.test.threadPoolExecutor;
//
//import java.security.AccessControlContext;
//import java.security.AccessController;
//import java.security.PrivilegedAction;
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.*;
//
///**
// * @Description:
// * @Auther: Jack You
// * @Date: 2021/11/17/14:50
// */
//public class MyThreadPoolExecutor {
//    //这个属性是用来存放 当前运行的worker数量以及线程池状态的
//    //int是32位的，这里把int的高3位拿来充当线程池状态的标志位,后29位拿来充当当前运行worker的数量
//    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
//    private static final int COUNT_BITS = Integer.SIZE - 3;
//    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
//
//    // runState is stored in the high-order bits
//    private static final int RUNNING    = -1 << COUNT_BITS;
//    private static final int SHUTDOWN   =  0 << COUNT_BITS;
//    private static final int STOP       =  1 << COUNT_BITS;
//    private static final int TIDYING    =  2 << COUNT_BITS;
//    private static final int TERMINATED =  3 << COUNT_BITS;
//
//    // Packing and unpacking ctl
//    private static int runStateOf(int c)     { return c & ~CAPACITY; }
//    private static int workerCountOf(int c)  { return c & CAPACITY; }
//    private static int ctlOf(int rs, int wc) { return rs | wc; }
//
//
//    //存放任务的阻塞队列
//    private final BlockingQueue<Runnable> workQueue;
//    //worker的集合,用set来存放
//    private final HashSet<Worker> workers = new HashSet<Worker>();
//    //历史达到的worker数最大值
//    private int largestPoolSize;
//    //当队列满了并且worker的数量达到maxSize的时候,执行具体的拒绝策略
//    private volatile RejectedExecutionHandler handler;
//    //超出coreSize的worker的生存时间
//    private volatile long keepAliveTime;
//    //常驻worker的数量
//    private volatile int corePoolSize;
//    //最大worker的数量,一般当workQueue满了才会用到这个参数
//    private volatile int maximumPoolSize;
//
//    public void execute(Runnable command) {
//        if (command == null)
//            throw new NullPointerException();
//        int c = ctl.get();
//        //workerCountOf(c)会获取当前正在运行的worker数量
//        if (workerCountOf(c) < corePoolSize) {
//            //如果workerCount小于corePoolSize,就创建一个worker然后直接执行该任务
//            if (addWorker(command, true))
//                return;
//            c = ctl.get();
//        }
//        //isRunning(c)是判断线程池是否在运行中,如果线程池被关闭了就不会再接受任务
//        //后面将任务加入到队列中
//        if (isRunning(c) && workQueue.offer(command)) {
//            //如果添加到队列成功了,会再检查一次线程池的状态
//            int recheck = ctl.get();
//            //如果线程池关闭了,就将刚才添加的任务从队列中移除
//            if (! isRunning(recheck) && remove(command))
//                //执行拒绝策略
//                reject(command);
//            else if (workerCountOf(recheck) == 0)
//                addWorker(null, false);
//        }
//        //如果加入队列失败,就尝试直接创建worker来执行任务
//        else if (!addWorker(command, false))
//            //如果创建worker失败,就执行拒绝策略
//            reject(command);
//    }
//
//    private boolean addWorker(Runnable firstTask, boolean core) {
//        retry:
//        //使用自旋+cas失败重试来保证线程竞争问题
//        for (;;) {
//            //先获取线程池的状态
//            int c = ctl.get();
//            int rs = runStateOf(c);
//
//            // 如果线程池是关闭的,或者workQueue队列非空,就直接返回false,不做任何处理
//            if (rs >= SHUTDOWN &&
//                    ! (rs == SHUTDOWN &&
//                            firstTask == null &&
//                            ! workQueue.isEmpty()))
//                return false;
//
//            for (;;) {
//                int wc = workerCountOf(c);
//                //根据入参core 来判断可以创建的worker数量是否达到上限,如果达到上限了就拒绝创建worker
//                if (wc >= CAPACITY ||
//                        wc >= (core ? corePoolSize : maximumPoolSize))
//                    return false;
//                //没有的话就尝试修改ctl添加workerCount的值。这里用了cas操作,如果失败了下一个循环会继续重试,直到设置成功
//                if (compareAndIncrementWorkerCount(c))
//                    //如果设置成功了就跳出外层的那个for循环
//                    break retry;
//                //重读一次ctl,判断如果线程池的状态改变了,会再重新循环一次
//                c = ctl.get();  // Re-read ctl
//                if (runStateOf(c) != rs)
//                    continue retry;
//            }
//        }
//
//        boolean workerStarted = false;
//        boolean workerAdded = false;
//        Worker w = null;
//        try {
//            final ReentrantLock mainLock = this.mainLock;
//            //创建一个worker,将提交上来的任务直接交给worker
//            w = new Worker(firstTask);
//            final Thread t = w.thread;
//            if (t != null) {
//                //加锁,防止竞争
//                mainLock.lock();
//                try {
//                    int c = ctl.get();
//                    int rs = runStateOf(c);
//                    //还是判断线程池的状态
//                    if (rs < SHUTDOWN ||
//                            (rs == SHUTDOWN && firstTask == null)) {
//                        //如果worker的线程已经启动了,会抛出异常
//                        if (t.isAlive())
//                            throw new IllegalThreadStateException();
//                        //添加新建的worker到线程池中
//                        workers.add(w);
//                        int s = workers.size();
//                        //更新历史worker数量的最大值
//                        if (s > largestPoolSize)
//                            largestPoolSize = s;
//                        //设置新增标志位
//                        workerAdded = true;
//                    }
//                } finally {
//                    mainLock.unlock();
//                }
//                //如果worker是新增的,就启动该线程
//                if (workerAdded) {
//                    t.start();
//                    //成功启动了线程,设置对应的标志位
//                    workerStarted = true;
//                }
//            }
//        } finally {
//            //如果启动失败了,会触发执行相应的方法
//            if (! workerStarted)
//                addWorkerFailed(w);
//        }
//        return workerStarted;
//    }
//
//    final void runWorker(Worker w) {
//        //获取当前线程
//        Thread wt = Thread.currentThread();
//        Runnable task = w.firstTask;
//        w.firstTask = null;
//        //执行unlock方法,允许其他线程来中断自己
//        w.unlock(); // allow interrupts
//        boolean completedAbruptly = true;
//        try {
//            //如果前面的firstTask有值,就直接执行这个任务
//            //如果没有具体的任务,就执行getTask()方法从队列中获取任务
//            //这里会不断执行循环体,除非线程中断或者getTask()返回null才会跳出这个循环
//            while (task != null || (task = getTask()) != null) {
//                //执行任务前先锁住,这里主要的作用就是给shutdown方法判断worker是否在执行中的
//                //shutdown方法里面会尝试给这个线程加锁,如果这个线程在执行,就不会中断它
//                w.lock();
//                //判断线程池状态,如果线程池被强制关闭了,就马上退出
//                if ((runStateAtLeast(ctl.get(), STOP) ||
//                        (Thread.interrupted() &&
//                                runStateAtLeast(ctl.get(), STOP))) &&
//                        !wt.isInterrupted())
//                    wt.interrupt();
//                try {
//                    //执行任务前调用。预留的方法,可扩展
//                    beforeExecute(wt, task);
//                    Throwable thrown = null;
//                    try {
//                        //真正的执行任务
//                        task.run();
//                    } catch (RuntimeException x) {
//                        thrown = x; throw x;
//                    } catch (Error x) {
//                        thrown = x; throw x;
//                    } catch (Throwable x) {
//                        thrown = x; throw new Error(x);
//                    } finally {
//                        //执行任务后调用。预留的方法,可扩展
//                        afterExecute(task, thrown);
//                    }
//                } finally {
//                    task = null;
//                    //记录完成的任务数量
//                    w.completedTasks++;
//                    w.unlock();
//                }
//            }
//            completedAbruptly = false;
//        } finally {
//            processWorkerExit(w, completedAbruptly);
//        }
//    }
//
//
//    //下面来看一下getTask()方法，这里面涉及到keepAliveTime的使用，
//    // 从这个方法我们可以看出先吃池是怎么让超过corePoolSize的那部分worker销毁的。
//    private Runnable getTask() {
//        boolean timedOut = false;
//
//        for (;;) {
//            int c = ctl.get();
//            int rs = runStateOf(c);
//
//            // 如果线程池已经关闭了,就直接返回null,
//            //如果这里返回null,调用的那个worker就会跳出while循环,然后执行完销毁线程
//            //SHUTDOWN状态表示执行了shutdown()方法
//            //STOP表示执行了shutdownNow()方法
//            if (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty())) {
//                decrementWorkerCount();
//                return null;
//            }
//            //获取当前正在运行中的worker数量
//            int wc = workerCountOf(c);
//
//            // 如果设置了核心worker也会超时或者当前正在运行的worker数量超过了corePoolSize,就要根据时间判断是否要销毁线程了
//            //其实就是从队列获取任务的时候要不要设置超时间时间,如果超过这个时间队列还没有任务进来,就会返回null
//            boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;
//
//            //如果上一次循环从队列获取到的未null,这时候timedOut就会为true了
//            if ((wc > maximumPoolSize || (timed && timedOut))
//                    && (wc > 1 || workQueue.isEmpty())) {
//                //通过cas来设置WorkerCount,如果多个线程竞争,只有一个可以设置成功
//                //最后如果没设置成功,就进入下一次循环,说不定下一次worker的数量就没有超过corePoolSize了,也就不用销毁worker了
//                if (compareAndDecrementWorkerCount(c))
//                    return null;
//                continue;
//            }
//
//            try {
//                //如果要设置超时时间,就设置一下咯
//                //过了这个keepAliveTime时间还没有任务进队列就会返回null,那worker就会销毁
//                Runnable r = timed ?
//                        workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
//                        workQueue.take();
//                if (r != null)
//                    return r;
//                //如果r为null,就设置timedOut为true
//                timedOut = true;
//            } catch (InterruptedException retry) {
//                timedOut = false;
//            }
//        }
//    }
//
//
//
//    private final class Worker
//            extends AbstractQueuedSynchronizer
//            implements Runnable
//    {
//        /**
//         * This class will never be serialized, but we provide a
//         * serialVersionUID to suppress a javac warning.
//         */
//        private static final long serialVersionUID = 6138294804551838833L;
//
//        /** Thread this worker is running in.  Null if factory fails. */
//        //运行的线程,前面addWorker方法中就是直接通过启动这个线程来启动这个worker
//        final Thread thread;
//        /** Initial task to run.  Possibly null. */
//        //当一个worker刚创建的时候,就先尝试执行这个任务
//        Runnable firstTask;
//        /** Per-thread task counter */
//        //记录完成任务的数量
//        volatile long completedTasks;
//
//        /**
//         * Creates with given first task and thread from ThreadFactory.
//         * @param firstTask the first task (null if none)
//         */
//        Worker(Runnable firstTask) {
//            setState(-1); // inhibit interrupts until runWorker
//            this.firstTask = firstTask;
//            //创建一个Thread,将自己设置给他,后面这个thread启动的时候,也就是执行worker的run方法
//            this.thread = getThreadFactory().newThread(this);
//        }
//
//        /** Delegates main run loop to outer runWorker  */
//        //这里调用了ThreadPoolExecutor的runWorker方法
//        public void run() {
//            runWorker(this);
//        }
//
//        // Lock methods
//        //
//        // The value 0 represents the unlocked state.
//        // The value 1 represents the locked state.
//
//        protected boolean isHeldExclusively() {
//            return getState() != 0;
//        }
//
//        protected boolean tryAcquire(int unused) {
//            if (compareAndSetState(0, 1)) {
//                setExclusiveOwnerThread(Thread.currentThread());
//                return true;
//            }
//            return false;
//        }
//
//        protected boolean tryRelease(int unused) {
//            setExclusiveOwnerThread(null);
//            setState(0);
//            return true;
//        }
//
//        public void lock()        { acquire(1); }
//        public boolean tryLock()  { return tryAcquire(1); }
//        public void unlock()      { release(1); }
//        public boolean isLocked() { return isHeldExclusively(); }
//
//        void interruptIfStarted() {
//            Thread t;
//            if (getState() >= 0 && (t = thread) != null && !t.isInterrupted()) {
//                try {
//                    t.interrupt();
//                } catch (SecurityException ignore) {
//                }
//            }
//        }
//    }
//}
