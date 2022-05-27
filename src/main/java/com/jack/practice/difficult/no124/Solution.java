package com.jack.practice.difficult.no124;


public class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return max;
    }

    public int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = Math.max(max(root.left), 0);
        int rightValue = Math.max(max(root.right), 0);
        int maxPathValue = root.val + Math.max(leftValue, rightValue);
        max = Math.max(leftValue + rightValue + root.val, max);
        return maxPathValue;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        System.out.println(new Solution().maxPathSum(treeNode));
    }
}
