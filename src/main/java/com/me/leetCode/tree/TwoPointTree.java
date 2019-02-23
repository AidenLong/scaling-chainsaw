package com.me.leetCode.tree;

import com.me.leetCode.TreeNode;

public class TwoPointTree {

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

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < max) {
                sum += max - min;
                min = prices[i];
                max = 0;
            }
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] > min) {
                max = prices[i];
            }
        }
        if (max != 0 && (max - min) > 0) {
            sum += max - min;
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    public int maxProfit3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 1 || word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) {
            return true;
        }
        return word.substring(1).equals(word.substring(1).toLowerCase());
    }

    public static void main(String[] args) {
        System.out.println(new TwoPointTree().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new TwoPointTree().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new TwoPointTree().maxProfit(new int[]{7,6,4,3,1}));
    }
}
