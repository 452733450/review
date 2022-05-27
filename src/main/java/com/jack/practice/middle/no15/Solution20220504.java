package com.jack.practice.middle.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution20220504 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    ;
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 先将i自增，然后判断i和i+1是否相等（重复），判断区间是i<j;只有过滤掉所有重复个数后才会跳出while
                    // i++ 返回原来的值，++i 返回加1后的值
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    j--;
                } else {
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution20220504().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list.size());
    }
}
