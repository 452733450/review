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
        for (int i = 2; i <= s.length() - 1; i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    public int translateNum2(int num) {
        String str = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= str.length(); i++) {
            int value = Integer.parseInt(str.substring(i - 2, i));
            int c;
            if (value >= 10 && value <= 25) {
                // 代表字符串可拆开翻译
                c = a + b;
            } else {
                c = b;
            }
            a = b;
            b = c;
        }
        return b;
    }

    public int translateNum3(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }



    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum3(1225));
    }
}
