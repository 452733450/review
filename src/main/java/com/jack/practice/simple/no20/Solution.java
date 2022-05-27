package com.jack.practice.simple.no20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if ((length % 2) != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean b = new Solution().isValid("()");
        System.out.println(b);
    }
}
