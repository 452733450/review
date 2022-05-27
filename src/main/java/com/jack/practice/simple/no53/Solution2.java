package com.jack.practice.simple.no53;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution2().maxSubArray(new int[]{4, -1, 2, 1});
        System.out.println(res);
    }
}
