package com.jack.review.leetcode.quickSort;

import java.util.Arrays;
import java.util.Random;

public class Solution20240319 {
    // 快速排序

    public int[] sortArray(int[] nums) {
       quickSort(nums, 0, nums.length - 1);
       return nums;
    }

    public void quickSort(int[]nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right-left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }
            while ((gt > left && nums[gt] > pivot)) {
                gt--;
            }
            if(lt >= gt) {
                break;
            }
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 5, 1};
        new Solution20240319().sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
