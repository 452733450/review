package com.jack.review.leetcode.linkedList;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/24/11:28
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode getListNode(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        return listNode;
    }
}
