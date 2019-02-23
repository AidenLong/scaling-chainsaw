package com.me.leetCode.one10;

import com.me.leetCode.TreeNode;

public class Solution {

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

}
