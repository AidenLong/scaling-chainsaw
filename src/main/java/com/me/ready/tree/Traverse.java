package com.me.ready.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Traverse {

    public static void preOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.print(pop.value + " ");
                if (pop.right != null) {
                    stack.push(pop.right);
                }
                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }
        }
    }

    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void postOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                stack2.push(pop);
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
                if (pop.right != null) {
                    stack1.push(pop.right);
                }
            }

            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
    }

    public static void levelOrder(TreeNode head) {
        if (head != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(head);
            while (!queue.isEmpty()) {
                int numer = queue.size();
                for (int i = 0; i < numer; i++) {
                    TreeNode poll = queue.poll();
                    System.out.print(poll.value + " ");
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }

                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        D.right = I;
        E.left = J;
        E.right = K;

        preOrder(A);
        System.out.println();
        inOrder(A);
        System.out.println();
        postOrder(A);
        System.out.println();
        levelOrder(A);
    }
}
