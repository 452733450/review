package com.jack.practice.middle.f142no142;

import com.jack.practice.ListNode;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/11/14/10:41
 */
public class Solution20221114 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
