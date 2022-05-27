package com.jack.practice.difficult.no25;

import com.jack.practice.ListNode;

public class Solution20220503 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = node;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution20220503 demo = new Solution20220503();
        ListNode listNode = demo.reverse(ListNode.getListNode());
        ListNode res = demo.reverseKGroup(ListNode.getListNode(), 3);
        System.out.println(listNode);
    }
}
