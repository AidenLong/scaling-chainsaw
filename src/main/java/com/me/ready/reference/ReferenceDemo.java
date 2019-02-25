package com.me.ready.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Autor syl
 * @Date 2019/2/25 13:06
 **/
public class ReferenceDemo {

    // 就算OOM也不会回收
    static Object strongRef = new Object();

    public static void main(String[] args) throws InterruptedException {
        Object obj = strongRef;
        strongRef = null;
        System.gc();
        System.out.println("gc之后:" + obj);

        // 软引用 只有在程序发生OOM异常之前回收
        Object softRef = new Object();
        SoftReference softReference = new SoftReference(softRef);
        System.out.println(softReference.get());
        // 回收
        softRef = null;
        softReference = null;
        System.gc();
        System.out.println(softRef);

        // 弱引用，gc之后就会被回收
        Object weekObj = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(weekObj);
        weekObj = null;
        System.out.println("before gc:" + weakReference.get());
        System.gc();
        System.out.println("after gc:" + weakReference.get());


        // 虚引用
        ReferenceQueue queue = new ReferenceQueue();
        Object phantomObj = new Object();
        PhantomReference phantomReference = new PhantomReference(phantomObj, queue);
        System.out.println(phantomReference.get());

        // 当gc执行前会将虚引用的对象放入到对应的队列中
        phantomObj = null;
        System.gc();
        System.out.println(phantomReference.get());
        Thread.sleep(200);
        System.out.println(queue.poll());
    }
}
