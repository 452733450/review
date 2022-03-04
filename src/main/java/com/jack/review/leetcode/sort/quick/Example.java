package com.jack.review.leetcode.sort.quick;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/04/14:51
 */
public class Example {
    public void quickSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        // 调用partition(int[] nums, int left, int right)
        // 返回的是已经归位的元素的下标
        int partition_index = partition(nums, start, end);
        // 递归地排序已经归位元素的左边和右边
        quickSort(nums, start, partition_index - 1);
        quickSort(nums, partition_index + 1, end);
    }

    public int partition(int[] nums, int left, int right) {
        int random_index = new Random().nextInt(right - left + 1) + left;
        swap(nums, random_index, left);

        int pivot_index = left;
        int pivot = nums[pivot_index];
        while (left < right) {
            while (left < right && nums[right] > pivot)
                right--;
            while (left < right && nums[left] <= pivot)
                left++;
            if (left < right)
                swap(nums, left, right);
        }
        swap(nums, pivot_index, left);
        return left;
    }

    public void swap(int[] nums, int i, int j) {
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
