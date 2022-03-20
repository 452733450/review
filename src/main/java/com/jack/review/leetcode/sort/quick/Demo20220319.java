package com.jack.review.leetcode.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class Demo20220319 {
    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitionIndex = partition(arr, start, end);
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }

    public int partition(int[] arr, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(arr, left, random);
        int i = left, j = right;
        int pivot = arr[left];
        while (i < j) {
            // 这里的2个边界比较必须有一个=
            while (i < j && arr[j] > pivot) {
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

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 6, 7, 2, 3};
        new Demo20220319().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
