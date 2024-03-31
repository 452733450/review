package com.jack.test;

import com.jack.practice.ListNode;

public class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode reverse = new Solution().reverse(listNode);
        System.out.println(reverse);
    }
}
