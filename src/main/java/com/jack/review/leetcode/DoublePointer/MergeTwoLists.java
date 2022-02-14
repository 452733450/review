package com.jack.review.leetcode.DoublePointer;

/**
 * @Description: 剑指 Offer 25. 合并两个排序的链表
 * @Auther: Jack You
 * @Date: 2022/02/14/16:54
 */
public class MergeTwoLists {
    /*输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    示例1：
    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode res = new MergeTwoLists().mergeTwoLists(l1, l2);
        System.out.println(res);
    }
}
