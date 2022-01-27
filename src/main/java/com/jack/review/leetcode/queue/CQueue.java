package com.jack.review.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 * @Auther: Jack You
 * @Date: 2022/01/21/15:35
 */
public class CQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    public CQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        // 在执行删除操作的时候我们首先看下第二个栈是否为空
        if (s2.isEmpty()) {
            // 如果为空，我们将第一个栈里的元素一个个弹出插入到第二个栈里，这样第二个栈里元素的顺序就是待删除的元素的顺序，
            // 要执行删除操作的时候我们直接弹出第二个栈的元素返回即可
            move();
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }

    private void move() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        int i = obj.deleteHead();
        System.out.println(i);
    }
}


