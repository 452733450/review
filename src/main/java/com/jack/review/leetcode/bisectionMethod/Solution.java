package com.jack.review.leetcode.bisectionMethod;

/**
 * @Description: 二分法 统计一个数字在排序数组中出现的次数
 * @Auther: Jack You
 * @Date: 2022/01/20/17:34
 */
public class Solution {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        // find first position
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return 0;
        }
        int l = left;
        // find last position
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left - l + 1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5,7,7,8,8,10},5));
    }
}
