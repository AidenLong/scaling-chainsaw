package com.me.ready.tree;

import java.util.HashMap;

public class Interview {

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
        TreeNode head = new TreeNode(preOrder[pstart] + "");
        int index = map.get(preOrder[pstart]);

        head.left = buildTree(preOrder, pstart + 1, pstart + index - istart, inOrder, istart, index - 1, map);
        head.right = buildTree(preOrder, pstart + index - istart + 1, pend, inOrder, index + 1, iend, map);
        return head;
    }
}
