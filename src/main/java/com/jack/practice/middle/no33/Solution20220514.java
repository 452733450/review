package com.jack.practice.middle.no33;

public class Solution20220514 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1 && nums[0] == target) {
            return 0;
        }
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[right]) {
                // 右半边升序数组
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左半边升序数组
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        // 当left == right时，判断nums[left]是不是target
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int a = new Solution20220514().search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(a);
    }
}
