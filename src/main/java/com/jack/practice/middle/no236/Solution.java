package com.jack.practice.middle.no236;

import com.jack.practice.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        TreeNode treeNode2 = new TreeNode(5, new TreeNode(6), treeNode1);
        TreeNode treeNode3 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, treeNode2, treeNode3);
        TreeNode res = new Solution().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
        System.out.println(res.val);
    }
}
