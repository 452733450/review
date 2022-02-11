package com.jack.review.leetcode.dynamicProgramming;

/**
 * @Description: 剑指 Offer 42. 连续子数组的最大和
 * @Auther: Jack You
 * @Date: 2022/02/10/14:38
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0], pre = nums[0];
        for (int i : nums) {
            i += Math.max(pre, 0);
            pre = i;
            max = Math.max(max, i);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int max = nums[0], pre = 0;
        for (int num: nums) {
            num += Math.max(pre,0);
            pre = num;
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
