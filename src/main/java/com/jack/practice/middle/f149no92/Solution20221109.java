package com.jack.practice.middle.f149no92;

import com.jack.practice.ListNode;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/11/09/13:47
 */
public class Solution20221109 {
    ListNode successor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1) {
            return reverseN(head, right);
        }
        // 如果 m != 1 怎么办？如果我们把 head 的索引视为 1，那么我们是想从第 m 个元素开始反转对吧；
        // 如果把 head.next 的索引视为 1 呢？那么相对于 head.next，反转的区间应该是从第 m - 1 个元素开始的；
        // 那么对于 head.next.next 呢
        // 因为这个翻转之后，就自动与之前的节点相连了，不需要再做其他的操作
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverseN(ListNode head, int n){
        if(n == 1) {
            // 只翻转第一位，相当于没做任何变动，直接返回原来的链表
            // 后继节点则是head.next
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode res = new Solution20221109().reverseBetween(listNode, 2, 4);
        System.out.println(res);
    }
}
