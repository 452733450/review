package com.jack.review.leetcode.DoublePointer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 剑指 Offer 18. 删除链表的节点
 * @Auther: Jack You
 * @Date: 2022/02/14/14:11
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }

    // 双指针，100.00%，12.30%
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }

    // 单指针，100.00%，9.92%
    public ListNode deleteNode3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode = new DeleteNode().deleteNode2(ListNode.getNode(), 4);
        System.out.println(listNode);
    }
}
