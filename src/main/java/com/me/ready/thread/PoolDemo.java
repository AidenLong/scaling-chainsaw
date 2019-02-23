package com.me.ready.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolDemo {

    static ExecutorService executorService1 = Executors.newSingleThreadExecutor();
    ExecutorService executorService2 = Executors.newFixedThreadPool(60);
    ExecutorService executorService3 = Executors.newCachedThreadPool();
    ExecutorService executorService4 = Executors.newScheduledThreadPool(60);

    public static void main(String[] args) {
        executorService1.execute(new Thread(()->{
            System.out.println("111");
        }));
    }
}
