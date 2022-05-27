package com.jack.practice.middle.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //排序，nums变成递增数组
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //k < nums.length - 2是为了保证后面还能存在两个数字
        for (int k = 0; k < nums.length - 2; k++) {
            //若nums[k]大于0，则后面的数字也是大于零（排序后是递增的）
            if (nums[k] > 0) break;
            //nums[k]值重复了，去重
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            //定义左右指针
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    //左指针前进并去重
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    //右指针后退并去重
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    //左指针前进并去重
                    while (i < j && nums[i] == nums[++i]) ;
                    //右指针后退并去重
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list.size());
    }
}
