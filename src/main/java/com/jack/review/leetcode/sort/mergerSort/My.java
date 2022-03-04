package com.jack.review.leetcode.sort.mergerSort;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/04/15:43
 */
public class My {
    int[] tmp;

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }


    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        tmp = new int[nums.length];
        int mid = (start + end) >> 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int i = start, j = mid + 1, t = 0;
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

        for (int k = 0; k < end - start + 1; k++) {
            nums[k + start] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1, 6};
        new My().sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

}
