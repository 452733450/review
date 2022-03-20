package com.jack.review.leetcode.sort.quick;

import java.util.Arrays;
import java.util.Random;

public class Demo20220319a {

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex);
        quickSort(arr, partitionIndex + 1, right);
    }

    public int partition(int[] arr, int left, int right) {
        int randomIndex = new Random().nextInt(right - left +1) + left;
        swap(arr, left, randomIndex);
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && pivot <= arr[j]) {
                j--;
            }
            while (i < j && pivot > arr[i]) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, i);
        return i;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 6, 7, 2, 3};
        new Demo20220319a().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
