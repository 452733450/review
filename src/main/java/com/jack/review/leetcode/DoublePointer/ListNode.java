package com.jack.review.leetcode.DoublePointer;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/02/14/14:12
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode getNode() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        return listNode;
    }

}
