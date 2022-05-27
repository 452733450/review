package com.jack.practice.simple.no206;


import com.jack.practice.ListNode;

public class Test20220501 {
    public ListNode reverseList(ListNode head) {
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
        ListNode res = new Test20220501().reverseList(ListNode.getListNode());
        System.out.println(res);
    }
}
