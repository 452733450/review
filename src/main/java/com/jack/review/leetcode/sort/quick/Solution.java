package com.jack.review.leetcode.sort.quick;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/04/13:09
 */
public class Solution {
    private void sortArr(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int partitionIndex = partition(arr, left, right);
        sortArr(arr, left, partitionIndex - 1);
        sortArr(arr, partitionIndex + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int randomIndex = getRandomIndex(left, right);
        swap(arr, left, randomIndex);
        int pivotIndex = left;
        int pivot = arr[pivotIndex];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, pivotIndex, left);
        return left;
    }

    private int getRandomIndex(int left, int right) {
        return new Random().nextInt(right - left + 1) + left;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1};
        new Solution().sortArr(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
