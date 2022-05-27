package com.jack.practice.simple.no88;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[length--] = nums2[j--];
            } else if (j == -1) {
                nums1[length--] = nums1[i--];
            } else if (nums1[i] >= nums2[j]) {
                nums1[length--] = nums1[i--];
            } else {
                nums1[length--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
