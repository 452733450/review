package com.jack.review.leetcode.find.search;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/26/16:25
 */
public class Solution2 {
    /*统计一个数字在排序数组中出现的次数。
    示例 1:

    输入: nums = [5,7,7,8,8,10], target = 8
    输出: 2
    示例 2:

    输入: nums = [5,7,7,8,8,10], target = 6
    输出: 0*/

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return 0;
        }

        int temp = left;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left - temp + 1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
