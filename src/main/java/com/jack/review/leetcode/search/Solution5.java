package com.jack.review.leetcode.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/28/16:16
 */
public class Solution5 {

    // 32.iii
    /*请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
    例如:
    给定二叉树: [3,9,20,null,null,15,7],

            3
            / \
            9  20
                /  \
                15   7
    返回其层次遍历结果：

            [
            [3],
            [20,9],
            [15,7]
            ]*/

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        addToList(root, 0);
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 != 0) {
                // 奇数从右到左打印
                List<Integer> list = res.get(i);
                List<Integer> temp = new ArrayList<>();
                for (int j = list.size() - 1; j >= 0; j--) {
                    temp.add(list.get(j));
                }
                res.set(i, temp);
            }
        }
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

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                assert node != null;
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val); // 偶数层 -> 队列头部
                } else {
                    tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
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
        List<List<Integer>> list = new Solution5().levelOrder(root);
        System.out.println(list.size());
    }
}
