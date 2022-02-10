package com.jack.review.leetcode.string.reverseLeftWords;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/26/13:44
 */
public class Solution {
    public static String reverseLeftWords(String s, int n) {
        String left = s.substring(0,n);
        String right = s.substring(n);
        return right +left;
    }

    public static void main(String[] args) {
        /*输入: s = "abcdefg", k = 2
        输出: "cdefgab"

        输入: s = "lrloseumgh", k = 6
        输出: "umghlrlose"*/

        System.out.println(reverseLeftWords("abcdefg",2));
        System.out.println(reverseLeftWords("lrloseumgh",6));
    }
}
