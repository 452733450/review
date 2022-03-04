package com.jack.review.leetcode.sort.mergerSort;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/04/17:47
 */
public class My3 {
    int []tmp;
    private void sortArray(int [] arr){
        tmp = new int[arr.length];
        sort(arr, 0, arr.length-1);
    }

    private void sort(int []arr, int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right)>> 1;
        sort(arr, left, mid);
        sort(arr, mid +1, right);
        merge(arr, left, right);
    }

    private void merge(int[] arr, int left, int right) {
        int mid = (left + right) >> 1;
        int i = left, j = mid+1, t = 0;
        while (i <= left && j <= right) {
            if (arr[i++] <= arr[j++]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= left) {
            tmp[t++] = arr[i++];
        }
        while (j <= right){
            tmp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1, 6};
        new My3().sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
