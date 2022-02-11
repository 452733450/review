package com.jack.review.leetcode.binaryTree;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/27/16:11
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(Integer x) {
        if(x == null) {
            return;
        }
        val = x;
    }

    public static TreeNode getRoot(){
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        root1.left = root2;
        root1.right = root3;
        TreeNode root4 = new TreeNode(null);
        TreeNode root5 = new TreeNode(3);
        root2.left = root4;
        root2.right = root5;
        TreeNode root6 = new TreeNode(null);
        TreeNode root7 = new TreeNode(9);
        root3.left = root6;
        root3.right = root7;
        return root1;
    }
}
