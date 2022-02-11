package com.jack.review.leetcode.search;

import java.util.*;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/28/11:03
 */
public class Solution4 {
    // 32.ii
    /*从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    例如:
    给定二叉树: [3,9,20,null,null,15,7],

            3
            / \
            9  20
            /  \
            15   7
    返回：

            [3,9,20,15,7]*/

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    public int[] levelOrder2(TreeNode root) {
        if (root == null) return new int[]{};
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> t = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                assert node != null;
                t.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        int i = 0, n = t.size();
        int[] res = new int[n];
        for (Integer e : t) {
            res[i++] = e;
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
        int[] arr = new Solution4().levelOrder(root);
        System.out.println(arr.length);
    }
}

