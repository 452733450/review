package com.jack.practice.middle.no912;

import com.jack.review.leetcode.quickSort.Solution4;

import java.util.Arrays;
import java.util.Random;

public class Solution20220505 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition_index = partition(nums, left, right);
        quickSort(nums, left, partition_index - 1);
        quickSort(nums, partition_index + 1, right);
    }

    public int partition(int[] arr, int left, int right) {
        int random_index = new Random().nextInt(right - left + 1) + left;
        swap(arr, left, random_index);
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        return i;
    }

    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 5, 1};
        new Solution20220505().sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
