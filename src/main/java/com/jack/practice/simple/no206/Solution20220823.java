package com.jack.practice.simple.no206;

import com.jack.practice.ListNode;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/23/13:17
 */
public class Solution20220823 {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
