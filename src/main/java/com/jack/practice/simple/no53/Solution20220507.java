package com.jack.practice.simple.no53;

public class Solution20220507 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre, pre + num);
            res = Math.max(pre, res);
        }
        return res;
    }
}
