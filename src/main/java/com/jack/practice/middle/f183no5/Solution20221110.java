package com.jack.practice.middle.f183no5;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/11/10/15:39
 */
public class Solution20221110 {
    public String longestPalindrome1(String s) {
        int length = s.length();
        int left, right;
        // 回文字符串的最大长度
        int strLength = 1;
        // for循环后最大的回文字符串长度
        int maxLength = 0;
        // 最大的回文字符串开始的位置
        int maxStart = 0;
        for (int i = 0; i < length; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && (s.charAt(left) == s.charAt(i))) {
                left--;
                strLength++;
            }
            while (right < length && (s.charAt(right) == s.charAt(i))) {
                right++;
                strLength++;
            }
            while (left >= 0 && right < length && left < right && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
                strLength += 2;
            }
            if (strLength > maxLength) {
                maxLength = strLength;
                maxStart = left;
            }
            strLength = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLength + 1);
    }

    public static void main(String[] args) {
        String str = "acdbbdaa";
        System.out.println(str.substring(2, 6));
        System.out.println(new Solution20221110().longestPalindrome1(str));
    }
}
