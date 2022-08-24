package com.jack.review.test;

public class Solution {

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode res = new Solution().reverse(listNode);
        System.out.println(res);
    }

}
