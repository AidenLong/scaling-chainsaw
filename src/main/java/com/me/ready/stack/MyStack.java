package com.me.ready.stack;

import com.me.ready.node.ListNode;

public class MyStack {

    private ListNode stackTop;
    private ListNode stackBottom;

    public MyStack(ListNode stackTop, ListNode stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    /**
     * 进栈
     * @param stack
     * @param value
     */
    public static void pushStack(MyStack stack, int value) {
        ListNode stackTop = new ListNode(value);
        stackTop.next = stack.stackTop;
        stack.stackTop = stackTop;
    }

    public static void traverse(MyStack stack) {
        ListNode stackTop = stack.stackTop;
        while (stackTop != stack.stackBottom) {
            System.out.print(stackTop.data + " ");
            stackTop = stackTop.next;
        }
        System.out.println();
    }

    public static boolean isEmpty(MyStack stack) {
        if (stack.stackTop == stack.stackBottom) {
            return true;
        } else {
            return false;
        }
    }

    public static void popStack(MyStack stack) {
        if (!isEmpty(stack)) {
            ListNode stackStop = stack.stackTop;
            stack.stackTop = stackStop.next;
            System.out.println(stackStop.data);
        }
    }

    public static void clearStack(MyStack stack) {
        stack.stackTop = null;
        stack.stackBottom = stack.stackTop;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0), new ListNode(0));
        myStack.stackTop = myStack.stackBottom;
        System.out.println(isEmpty(myStack));
        pushStack(myStack,1);
        pushStack(myStack,2);
        pushStack(myStack,3);
        traverse(myStack);
        System.out.println(isEmpty(myStack));
        popStack(myStack);
        traverse(myStack);
        clearStack(myStack);
        System.out.println(isEmpty(myStack));
    }
}
