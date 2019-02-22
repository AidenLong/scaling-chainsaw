package com.me.ready;

/**
 * @Autor syl
 * @Date 2019/2/22 16:10
 **/
public class SingleTon {

    public static SingleTon instance = new SingleTon();

    private static int count1;
    private static int count2 = 0;

    public SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        System.out.println("count1:" + instance.count1);
        System.out.println("count2:" + instance.count2);
    }
}
