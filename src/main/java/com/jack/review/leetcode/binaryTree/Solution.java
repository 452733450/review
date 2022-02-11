package com.jack.review.leetcode.binaryTree;


/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/29/13:48
 */
/*请完成一个函数，输入一个二叉树，该函数输出它的镜像。

        例如输入：
             4
           /   \
          2     7
         / \   / \
        1   3 6   9
        镜像输出：
             4
           /   \
          7     2
         / \   / \
        9   6 3   1
        示例 1：
        输入：root = [4,2,7,1,3,6,9]
        输出：[4,7,2,9,6,3,1]*/
// 剑指 Offer 27. 二叉树的镜像
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        changePosition(root);
        return root;
    }

    private void changePosition(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if (root.left != null) {
            changePosition(root.left);
        }
        if (root.right != null) {
            changePosition(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode res = new Solution().mirrorTree(TreeNode.getRoot());
        System.out.println(res);
    }
}
