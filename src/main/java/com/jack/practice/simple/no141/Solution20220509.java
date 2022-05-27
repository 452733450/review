package com.jack.practice.simple.no141;

import com.jack.practice.ListNode;

public class Solution20220509 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast == null || fast.next == null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next =node2;
        node2.next = node1;


        boolean b = new Solution20220509().hasCycle(node1);
        System.out.println(b);
    }
}
