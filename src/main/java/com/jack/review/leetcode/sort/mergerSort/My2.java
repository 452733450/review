package com.jack.review.leetcode.sort.mergerSort;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/04/16:34
 */
public class My2 {
    int[] tmp;

    private void mergeSort(int[] nums) {
        tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, end);
    }

    private void merge(int[] nums, int start, int end) {
        int i = start, mid = (start + end) >> 1;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                tmp[t++] = nums[i++];
            } else {
                tmp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = nums[i++];
        }
        while (j <= end) {
            tmp[t++] = nums[j++];
        }

        t = 0;
        while (start <= end) {
            nums[start++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1, 6};
        new My2().mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
