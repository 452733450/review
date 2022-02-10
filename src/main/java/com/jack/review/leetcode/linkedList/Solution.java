package com.jack.review.leetcode.linkedList;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/24/10:22
 */
public class Solution {
    /*输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    示例 1：
    输入：head = [1,3,2]
    输出：[2,3,1]*/
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    public static int[] reversePrint2(ListNode head) {
        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while (currNode != null) {
            len++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while (currNode != null) {
            result[len - 1] = currNode.val;
            len--;
            currNode = currNode.next;
        }
        return result;
    }

    public int[] reversePrint3(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        int arr[] = reversePrint(listNode);
        System.out.println(arr);
    }

    /*复杂性分析
    时间复杂度：O(n)O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
    空间复杂度：O(n)O(n)。额外使用一个栈存储链表中的每个节点。*/
}
