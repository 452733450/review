package com.jack.review.leetcode.linkedList2;

import com.jack.review.leetcode.linkedList.ListNode;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/24/15:49
 */
public class Solution {
    public static ListNode reverseList(ListNode head) {
        // 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 在更改引用之前，还需要存储后一个节点
            ListNode next = curr.next;
            // 将当前节点的 next 指针改为指向前一个节点
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode cur = reverseList2(head);
        System.out.println(cur);
    }

}
