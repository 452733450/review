package com.jack.practice.middle.f142no142;

import com.jack.practice.ListNode;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/17/16:48
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 我觉得讲的很清楚了 get到的关键点是：
        // 走a+nb步一定是在环入口
        // 第一次相遇时慢指针已经走了nb步
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {

    }
}
