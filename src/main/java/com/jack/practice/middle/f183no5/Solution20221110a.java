package com.jack.practice.middle.f183no5;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/11/10/15:39
 */
public class Solution20221110a {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLength = 1;
        int maxStart = 0, maxEnd = 0;
        for (int r = 1; r < length ; r++) {
            for (int l = 0; l < r; l++) {
                if(s.charAt(l)==s.charAt(r) && ((r-l < 2) || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if(r-l +1>maxLength) {
                        maxLength = r-l +1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        String str = "acdbbdaa";
        System.out.println(str.substring(2, 6));
        System.out.println(new Solution20221110a().longestPalindrome(str));
    }
}
