package com.jack.review.leetcode.sort.mergerSort;

import java.util.Arrays;

public class Demo20220319a {
    int[] tmp;

    public void sortArray(int[] arr) {
        tmp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    public void merge(int[] arr, int left, int right) {
        int mid = (left + right) >> 1;
        int i = left, j = mid + 1, t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] >= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (j <= right) {
            tmp[t++] = arr[j++];
        }
        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1, 6};
        new Demo20220319a().sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
