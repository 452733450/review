package com.jack.review.leetcode.linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description: 反转链表
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


    /*好理解的双指针
    定义两个指针： prepre 和 curcur ；prepre 在前 curcur 在后。
    每次让 prepre 的 nextnext 指向 curcur ，实现一次局部反转
    局部反转完成之后，prepre 和 curcur 同时往前移动一个位置
    循环上述过程，直至 prepre 到达链表尾部*/
    public static int[] reverse(ListNode head) {
        ListNode pre = null, cur = head;
        int len = 0;
        while (cur != null){
            len ++;
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        int []nums = new int[len];
        for (int i = 0; i <len ; i++) {
            assert pre != null;
            nums[i] = pre.val;
            pre = pre.next;
        }
        return nums;
    }

    private static int[] reverse2(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int length = stack.size();
        int[] nums = new int[length];
        for (int i = 0; i <length ; i++) {
            nums[i] = stack.pop().val;
        }
        return nums;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        /*int arr[] = reversePrint(listNode);*/
        int [] arr= reverse2(listNode);
        System.out.println(Arrays.toString(arr));
    }

    /*复杂性分析
    时间复杂度：O(n)O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
    空间复杂度：O(n)O(n)。额外使用一个栈存储链表中的每个节点。*/
}
