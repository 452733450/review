package com.jack.practice.simple.no1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution20220505 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] res = new Solution20220505().twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(res));
    }
}
