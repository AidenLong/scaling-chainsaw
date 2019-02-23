package com.me.ready.thread;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    private static int i;
    // 内存屏障 javap -v InterruptDemo.class 防止文件重排序
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            /*while (!Thread.currentThread().isInterrupted()) {
                i++;
            }*/
            while (!stop) {
                i++;
            }
            System.out.println("num:" + i);
        });
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        stop = true;
//        thread.interrupt();
    }
}
