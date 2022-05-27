package com.jack.practice.middle.no103;

import com.jack.practice.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if (count % 2 != 0) {
                Collections.reverse(level);
            }
            res.add(level);

            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), treeNode1);
        List<List<Integer>> res = new Solution().zigzagLevelOrder(treeNode);
        System.out.println(res.size());
    }
}
