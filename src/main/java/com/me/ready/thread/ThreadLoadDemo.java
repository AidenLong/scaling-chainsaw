package com.me.ready.thread;

public class ThreadLoadDemo {

    private static int num = 0;

    private static ThreadLocal<Integer> number = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0; // 初始值
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
//                num += 5;
                int localNum = number.get().intValue() + 5;
                System.out.println(Thread.currentThread().getName() + "->" + localNum);
            }, "Thread_" + i).start();
        }
    }
}
