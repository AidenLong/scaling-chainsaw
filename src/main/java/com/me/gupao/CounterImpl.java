package com.me.gupao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Autor syl
 * @Date 2019/3/8 21:40
 **/
public class CounterImpl implements ICounter {

    private final StatData statData = new StatData();

    private AtomicInteger integer = new AtomicInteger();

    private Queue<Integer> last10SecondQueue = new ConcurrentLinkedDeque<>();
    private Queue<Integer> last10MinuteQueue = new ConcurrentLinkedDeque<>();
    private Queue<Integer> last60MinuteQueue = new ConcurrentLinkedDeque<>();
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    @Override
    public void hit() {
        integer.getAndIncrement();
    }

    @Override
    public StatData getStat() {
        return statData;
    }

    public CounterImpl() {
        statData.last60SecondHistory = Collections.synchronizedList(new ArrayList<>());
        executor.scheduleWithFixedDelay(() -> {
            last10SecondQueue.offer(integer.intValue());
            last10MinuteQueue.offer(integer.intValue());
            last60MinuteQueue.offer(integer.intValue());
            statData.last60SecondHistory.add(integer.intValue());
            if (last10SecondQueue.size() > 10) {
                last10SecondQueue.poll();
            }
            if (last10MinuteQueue.size() > 10 * 60) {
                last10MinuteQueue.poll();
            }
            if (last60MinuteQueue.size() > 10 * 10 * 60) {
                last60MinuteQueue.poll();
            }
            if (statData.last60SecondHistory.size() > 60) {
                statData.last60SecondHistory.remove(0);
            }
            integer = new AtomicInteger();
            statData.last10SecondAverage = (int)last10SecondQueue.stream().mapToInt(Integer::intValue).average().getAsDouble();
            statData.last10MinuteAverage = (int)last10MinuteQueue.stream().mapToInt(Integer::intValue).average().getAsDouble();
            statData.last60MinuteAverage = (int)last60MinuteQueue.stream().mapToInt(Integer::intValue).average().getAsDouble();
        },1, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ICounter iCounter = new CounterImpl();

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(101);
        for (int i = 0; i < 100; i++) {
            executor.scheduleWithFixedDelay(() -> {
                iCounter.hit();
            }, 0, 1, TimeUnit.MILLISECONDS);
        }

        executor.scheduleWithFixedDelay(() -> {
            System.out.println(iCounter.getStat());
        }, 1, 1, TimeUnit.SECONDS);
    }
}
