package com.jack.review.leetcode.binaryTree;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 剑指 Offer 28. 对称的二叉树
 * @Auther: Jack You
 * @Date: 2022/01/29/14:13
 */

/*请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

            1
           / \
          2   2
         / \ / \
        3  4 4  3
        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

            1
           / \
          2   2
           \   \
           3    3

         

        示例 1：

        输入：root = [1,2,2,3,4,4,3]
        输出：true
        示例 2：

        输入：root = [1,2,2,null,3,null,3]
        输出：false*/

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    boolean recur(TreeNode L, TreeNode R) {
        // 当 LL 和 RR 同时越过叶节点： 此树从顶至底的节点都对称，因此返回 true；
        if (L == null && R == null) return true;
        // 当 LL 或 RR 中只有一个越过叶节点： 此树不对称，因此返回 false ；
        // 当节点 LL 值  != 节点 RR 值： 此树不对称，因此返回 false
        if (L == null || R == null || L.val != R.val) return false;
        // 判断两节点 L.leftL.left 和 R.rightR.right 是否对称，即 recur(L.left, R.right) ；
        // 判断两节点 L.rightL.right 和 R.leftR.left 是否对称，即 recur(L.right, R.left) ；
        return recur(L.left, R.right) && recur(L.right, R.left);
    }


    public static void main(String[] args) {
        System.out.println(new IsSymmetric().isSymmetric(TreeNode.getRoot()));
    }
}
