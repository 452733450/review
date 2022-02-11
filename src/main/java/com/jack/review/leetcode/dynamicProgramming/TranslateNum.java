package com.jack.review.leetcode.dynamicProgramming;

/**
 * @Description: 剑指 Offer 46. 把数字翻译成字符串
 * @Auther: Jack You
 * @Date: 2022/02/11/14:51
 */
public class TranslateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(12258));
    }
}
