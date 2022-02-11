package com.jack.review.leetcode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/28/10:04
 */
public class Solution3 {
    List<List<Integer>> ret;
    public List<List<Integer>> levelOrder(TreeNode root) {
        ret = new ArrayList<>();
        dfs(0, root);
        return ret;
    }

    // 定义：传入树的深度，和一个跟节点root, 将当前深度(层)的节点放到对应的List中
    public void dfs(int depth, TreeNode root) {
        if (root == null) return;
        if (depth == ret.size()) { // 新建一个列表存放新的一层节点
            ret.add(new ArrayList<>());
        }
        ret.get(depth).add(root.val);
        // 递归的遍历左右子树
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
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
        List<List<Integer>> list = new Solution3().levelOrder(root);
        System.out.println(list.size());
    }
}
