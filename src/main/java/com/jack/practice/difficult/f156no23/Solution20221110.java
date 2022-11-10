package com.jack.practice.difficult.f156no23;

import com.jack.practice.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/11/10/11:09
 */
public class Solution20221110 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode listNode:lists) {
            if(listNode != null) {
                priorityQueue.add(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;


        while (!priorityQueue.isEmpty()) {
            p.next = priorityQueue.poll();
            p = p.next;
            if(p.next != null) {
                // 当前节点的后续链表不为空，则重新加入优先队列
                priorityQueue.add(p.next);
            }
        }
        return dummy.next;
    }
}
