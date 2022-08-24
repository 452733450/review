package com.jack.review.leetcode.sort.quick;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Auther: Jack You
 * @Date: 2022/08/23/13:45
 */
public class Solution20220823 {
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex);
        quickSort(arr, partitionIndex + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && pivot <= arr[j]) {
                j--;
            }
            while (i < j && pivot > arr[i]) {
                i++;
            }
            if(i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 6, 7, 2, 3};
        new Solution20220823().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
