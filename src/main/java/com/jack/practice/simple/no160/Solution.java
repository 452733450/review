package com.jack.practice.simple.no160;

import cn.hutool.core.date.DateTime;
import com.jack.practice.ListNode;

import java.util.Date;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    public static void main(String[] args) {
        String str = "2022-05-10";
    }
}
