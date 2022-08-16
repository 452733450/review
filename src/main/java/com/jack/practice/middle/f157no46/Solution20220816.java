package com.jack.practice.middle.f157no46;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/16/14:05
 */
public class Solution20220816 {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        boolean[] used = new boolean[length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, length, res, 0, used, path);
        return res;
    }

    private void dfs(int[] nums, int length, List<List<Integer>> res, int depth, boolean[] used, List<Integer> path) {
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, length, res, depth + 1, used, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution20220816 solution = new Solution20220816();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}
