package com.jack.practice.simple.no206;

import com.jack.practice.ListNode;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/23/13:17
 */
public class Solution20240319 {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
