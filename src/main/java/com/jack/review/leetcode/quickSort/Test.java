package com.jack.review.leetcode.quickSort;

import java.util.Arrays;

/**
 * @Description: 快速排序模板
 * @Auther: Jack You
 * @Date: 2022/03/03/14:16
 */
public class Test {

    public int[] sortIntegers(int[] A) {
        sort(A, 0, A.length - 1);
        return A;
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start, j = end;
        // key point 1:pivot is the value, not the index
        int pivot = A[(start + end) / 2];

        // key point 2:every time you compare i & j,
        // it should be i <= j not i < j
        while (i <= j) {
            while (i <= j && A[i] < pivot) {
                i++;
            }
            while (i <= j && A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

                i++;
                j--;
            }
        }
        quickSort(A, start, j);
        quickSort(A, i, end);
    }

    private void sort(int[] arr, int left, int right) {
        if(left > right) {
            return;
        }
        int pivot = arr[left];
        int i = left, j= right;
        while (i < j) {
            while (i < j && arr[j] >= pivot){
                j --;
            }
            while (i < j && arr[i] <= pivot) {
                i ++;
            }
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        sort(arr, left, i-1);
        sort(arr, i+1, right);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test().sortIntegers(new int[]{4, 3, 2, 1, 5, 6,7})));
    }
}
