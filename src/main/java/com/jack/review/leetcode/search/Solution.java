package com.jack.review.leetcode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/27/16:10
 */
public class Solution {
    // 32.ii
    /*例如:
    给定二叉树: [3,9,20,null,null,15,7],
            3
            / \
            9  20
                /  \
                15   7
    返回其层次遍历结果：
            [
            [3],
            [9,20],
            [15,7]
            ]*/
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return res;
        }
        addToList(root, 0);
        return res;
    }

    private void addToList(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (res.size() == height) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);

        addToList(root.left, height + 1);
        addToList(root.right, height + 1);
    }

    private void test(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;

        TreeNode left1 = new TreeNode(15);
        TreeNode right1 = new TreeNode(7);
        right.left = left1;
        right.right = right1;
        List<List<Integer>> list = new Solution().levelOrder(root);
        System.out.println(list.size());
    }
}
