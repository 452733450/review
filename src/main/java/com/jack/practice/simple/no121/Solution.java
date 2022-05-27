package com.jack.practice.simple.no121;

public class Solution {
    public int maxProfit(int[] prices) {
        // 前一天可卖出的最大利润
        int pre = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            pre = Math.max(0, pre + diff);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int a = new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(a);
    }
}
