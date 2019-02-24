package com.me.leetCode.one10;

import com.me.leetCode.TreeNode;

import java.util.*;

public class Solution {

    // 101
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.right, root.left);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
        } else {
            return false;
        }
        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }

    // 102
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int number = queue.size();
                List<Integer> e = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                    TreeNode poll = queue.poll();
                    e.add(poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
                result.add(e);
            }
        }
        return result;
    }

    // 103
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int j = 1;
            while (!queue.isEmpty()) {
                int number = queue.size();
                List<Integer> e = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                    TreeNode poll = queue.poll();
                    if (j % 2 == 1) {
                        e.add(0, poll.val);
                    } else {
                        e.add(poll.val);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                }
                result.add(e);
                j++;
            }
        }
        return result;
    }

    // 104
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    // 105
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
    }

    private TreeNode buildTree(int[] preOrder, int pstart, int pend, int[] inOrder, int istart, int iend, HashMap<Integer, Integer> map) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        TreeNode head = new TreeNode(preOrder[pstart]);
        int index = map.get(preOrder[pstart]);

        head.left = buildTree(preOrder, pstart + 1, pstart + index - istart, inOrder, istart, index - 1, map);
        head.right = buildTree(preOrder, pstart + index - istart + 1, pend, inOrder, index + 1, iend, map);
        return head;
    }

    // 106


    // 108
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                head.left = new TreeNode(nums[i]);
            }
        }
        return null;
    }
}
