package com.jack.review.leetcode.linkedList;

public class Demo20220319 {

    // 用三个变量：pre表示遍历过的上一个节点，cur表示遍历中当中正指向的节点，next下一个要遍历到的节点
    // 要实现反转就是当前cur指针的next节点指向前一个pre指针
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
        ListNode res = new Demo20220319().reverseList(ListNode.getListNode());
        System.out.println(res);
    }
}
