package com.me.ready.queue;

public class MyQueue {

    private int[] arrays;
    private int front;  // 第一个有效元素
    private int rear;   // 最后一个有效元素的下一个元素，即无效元素

    public MyQueue(int[] arrays, int front, int rear) {
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    public static boolean isFull(MyQueue myQueue) {
        return (myQueue.rear + 1) % myQueue.arrays.length == myQueue.front;
    }

    public static boolean isEmpty(MyQueue myQueue) {
        return myQueue.front == myQueue.rear;
    }

    public static void enQueue(MyQueue myQueue, int value) {
        if (!isFull(myQueue)) {
            myQueue.arrays[myQueue.rear] = value;
            myQueue.rear = (myQueue.rear + 1) % myQueue.arrays.length;
        }
    }

    public static void tarverse(MyQueue myQueue) {
        int i = myQueue.front;
        while (i != myQueue.rear) {
            System.out.print(myQueue.arrays[i] + " ");
            i = (i + 1) % myQueue.arrays.length;
        }
        System.out.println();
    }

    public static void outQueue(MyQueue myQueue) {
        if (!isEmpty(myQueue)) {
            int value = myQueue.arrays[myQueue.front];
            System.out.println(value);
            myQueue.front = (myQueue.front + 1) % myQueue.arrays.length;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(new int[6], 0, 0);
        System.out.println(isEmpty(myQueue));
        enQueue(myQueue, 1);
        enQueue(myQueue, 2);
        enQueue(myQueue, 3);
        enQueue(myQueue, 4);
        System.out.println(isFull(myQueue));
        enQueue(myQueue, 5);
        System.out.println(isFull(myQueue));
        tarverse(myQueue);
        outQueue(myQueue);
    }
}
