package com.jack.review.leetcode.binaryTree;

/**
 * @Description: 剑指 Offer 26. 树的子结构
 * @Auther: Jack You
 * @Date: 2022/02/07/11:26
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
