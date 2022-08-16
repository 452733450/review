package com.jack.practice.middle.f157no46;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/08/16:47
 */
public class Solution20220808 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 布尔数组 used，初始化的时候都为 false 表示这些数还没有被选择，当我们选定一个数的时候，就将这个数组的相应位置设置为 true
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        // depth: 一个变量来表示当前程序递归到第几层
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            // 一个变量来表示当前程序递归到第几层
            // 递归的终止条件是： 一个排列中的数字已经选够了
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);
                System.out.println("  递归之后 => " + path);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution20220808 solution = new Solution20220808();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
