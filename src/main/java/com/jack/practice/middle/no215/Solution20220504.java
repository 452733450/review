package com.jack.practice.middle.no215;

import java.util.Arrays;
import java.util.Random;

public class Solution20220504 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1, target_index = k - 1;
        while (true) {
            int partition_index = partition(nums, left, right);
            if (partition_index == target_index) {
                return nums[partition_index];
            } else if (partition_index > target_index) {
                right = partition_index - 1;
            } else {
                left = partition_index + 1;
            }
        }
    }

    public int partition(int[] arr, int start, int end) {
        // 支点
        int random_index = new Random().nextInt(end - start + 1) + start;
        // 随机取个支点后，与左边界的值交换值
        swap(arr, start, random_index);
        int pivot = arr[start];
        int left = start, right = end;
        while (left < right) {
            // 把比支点小的值放在右边，比支点大的值放在左边就是降序
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            if (left < right) {
                // 左右边界各找到一个，交换位置
                swap(arr, left, right);
            }
        }
        // 给支点找到位置后，将支点的值移动到它该在的位置
        swap(arr, start, left);

        return left;
    }

    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition_index = partition(arr, start, end);
        quickSort(arr, 0, partition_index - 1);
        quickSort(arr, partition_index + 1, end);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        new Solution20220504().quickSort(arr, 0, arr.length - 1);

        /*int value = new Solution20220504().findKthLargest(arr, 4);
        System.out.println(value);*/
        System.out.println(Arrays.toString(arr));
    }
}
