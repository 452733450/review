package com.jack.practice.middle.f136no300;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/11/16/16:22
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length, res = 0;
        if (length == 0) return res;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
