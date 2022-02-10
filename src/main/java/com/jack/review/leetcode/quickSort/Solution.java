package com.jack.review.leetcode.quickSort;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/21/14:54
 */
public class Solution {
    /*给定你一个长度为 n 的整数数列。
    请你使用快速排序对这个数列按照从小到大进行排序。
    并将排好序的数列按顺序输出。
    输入格式
    输入共两行，第一行包含整数 n。
    第二行包含 n 个整数（所有整数均在 1∼10^9 范围内），表示整个数列。
    输出格式
    输出共一行，包含 n 个整数，表示排好序的数列。
    数据范围
    1≤n≤100000
    输入样例：
            5
            3 1 2 4 5
    输出样例：
            1 2 3 4 5*/

    void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left - 1, j = right + 1;
        int x = nums[left];
        while (i < j) {
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }
}
