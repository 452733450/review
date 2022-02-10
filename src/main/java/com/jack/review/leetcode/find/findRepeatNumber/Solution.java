package com.jack.review.leetcode.find.findRepeatNumber;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/26/13:59
 */
public class Solution {
    /*找出数组中重复的数字。
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    示例 1：
    输入：
            [2, 3, 1, 0, 2, 5, 3]
    输出：2 或 3*/

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        for (int i = 0, n = nums.length; i < n; ++i) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) return nums[i];
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
