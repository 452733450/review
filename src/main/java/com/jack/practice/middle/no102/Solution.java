package com.jack.practice.middle.no102;

import com.jack.practice.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 队列长度一定要提取出来
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(level);

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), treeNode1);
        List<List<Integer>> res = new Solution().levelOrder(treeNode);
        System.out.println(res.size());
    }


}
