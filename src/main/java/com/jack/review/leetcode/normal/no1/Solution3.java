package com.jack.review.leetcode.normal.no1;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/30/11:04
 */
public class Solution3 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int[] rs = twoSum(new int[]{1, 2, 3, 4}, 5);
        stopWatch.stop();
        System.out.println("执行时间:" + stopWatch.getLastTaskTimeMillis() + "毫秒");
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i]);
        }
    }
}
