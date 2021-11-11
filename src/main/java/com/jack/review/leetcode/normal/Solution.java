package com.jack.review.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/30/11:04
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    list.add(i);
                    list.add(j);
                }
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
       int[] rs =  twoSum(new int[]{1, 2, 3, 4},5);
        for (int i = 0; i <rs.length ; i++) {
            System.out.println(rs[i]);
        }
    }
}
