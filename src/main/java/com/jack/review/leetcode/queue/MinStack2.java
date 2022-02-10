package com.jack.review.leetcode.queue;

import java.util.Stack;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/24/9:55
 */
public class MinStack2 {
    Stack<Integer> A, B;
    public MinStack2() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        MinStack2 obj = new MinStack2();
        obj.push(1);
        obj.push(3);
        obj.push(2);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.min();
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
