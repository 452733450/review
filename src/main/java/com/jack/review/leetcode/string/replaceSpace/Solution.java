package com.jack.review.leetcode.string.replaceSpace;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/26/13:17
 */
public class Solution {
    public static String replaceSpace(String s) {
        return s.replaceAll(" ", "%");
    }

    public static String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }


    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
        System.out.println(replaceSpace2(s));
    }
}
