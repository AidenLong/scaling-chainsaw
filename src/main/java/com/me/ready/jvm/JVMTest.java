package com.me.ready.jvm;

/**
 * @Autor syl
 * @Date 2019/2/25 10:53
 **/
public class JVMTest {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        obj2 = obj1;
        obj1 = obj2;
        System.gc();
    }
}
