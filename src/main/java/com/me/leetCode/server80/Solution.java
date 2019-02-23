package com.me.leetCode.server80;

import com.me.leetCode.TreeNode;

public class Solution {

    public int pre = -999, min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return min;
    }

    private void traverse(TreeNode root) {
        if(root != null){
            if(root.left != null)
                traverse(root.left);
            if(root.val - pre < min) min = root.val - pre;
            pre = root.val;
            if(root.right != null)
                traverse(root.right);
        }
    }
}
