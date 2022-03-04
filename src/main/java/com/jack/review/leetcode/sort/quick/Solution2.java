package com.jack.review.leetcode.sort.quick;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/04/15:01
 */
public class Solution2 {
    public void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int partitionIndex = partition(nums, start, end);
        quickSort(nums, start, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, end);
    }

    // 找到排好序的数的序列号
    private int partition(int[] nums, int start, int end) {
        int randomIndex = new Random().nextInt(end - start + 1) + start;
        swap(nums, randomIndex, start);
        int pivot = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 5, 1};
        new Example().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
