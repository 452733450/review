package com.jack.practice.simple.no1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/23/13:28
 */
public class Solution20240319 {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++) {
           if(map.containsKey(target- nums[i])) {
               return new int[]{i, map.get(target - nums[i])};
           } else {
               map.put(nums[i], i);
           }
       }
       return new int[]{};
    }

    public static void main(String[] args) {
        int[] res = new Solution20240319().twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(res));
    }
}
