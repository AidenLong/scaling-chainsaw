package com.me.ready.queue;

import java.util.Stack;

public class TwoStackOneQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(Integer value) {
        stackPush.push(value);
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackOneQueue twoStackOneQueue = new TwoStackOneQueue(new Stack<>(), new Stack<>());
        twoStackOneQueue.add(1);
        twoStackOneQueue.add(2);
        twoStackOneQueue.add(3);
        System.out.println(twoStackOneQueue.poll());
        System.out.println(twoStackOneQueue.poll());
        System.out.println(twoStackOneQueue.peek());
        System.out.println(twoStackOneQueue.peek());
    }
}
