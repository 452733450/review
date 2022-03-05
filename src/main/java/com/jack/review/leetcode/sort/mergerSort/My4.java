package com.jack.review.leetcode.sort.mergerSort;

import java.util.Arrays;

public class My4 {
    int[] tmp;

    private void sortArray(int[] nums) {
        tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, right);
    }

    private void merge(int[] nums, int left, int right) {
        int mid = (left + right) >> 1;
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                tmp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = nums[i++];
        }
        while (j <= right) {
            tmp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1, 6};
        new My4().sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
