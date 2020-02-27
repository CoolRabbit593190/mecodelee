package x.y.z.rabbit.leetcode.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author <a href="zhanghui.wj@cai-inc.com">无忌</a>
 * @Date 2020/2/27 10:22 上午 Copyright (c) 2016 政采云有限公司
 */
public class Foo{

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);


    public Foo() {
    }



    public void one() {
        System.out.println("one");
    }

    public void two() {
        System.out.println("two");
    }

    public void three() {
        System.out.println("three");
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }

    public static void main(String[] args) {
//        AtomicInteger ato = new AtomicInteger(1);
//        Object lock = new Object();
//        Foo foo = new Foo();
//        new Thread(() -> {
//            try {
//                foo.first(new one());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                foo.second(new two());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                foo.third(new three());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        final Foo foo = new Foo();
        ExecutorService pool = Executors.newCachedThreadPool();
//        ExecutorService pool = new ThreadPoolExecutor(3,
//            3, 0L, TimeUnit.MILLISECONDS,
//            new ArrayBlockingQueue<Runnable>(3), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        final Runnable printFirst = new Runnable() {
            @Override
            public void run() {
                foo.one();
            }
        };
        final Runnable printSecond = new Runnable() {
            @Override
            public void run() {
                foo.two();
            }
        };
        final Runnable printThird = new Runnable() {
            @Override
            public void run() {
                foo.three();
            }
        };
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(printFirst);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(printSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }



}
