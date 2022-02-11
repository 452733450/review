package com.jack.review.leetcode.dynamicProgramming;

/**
 * @Description: 剑指 Offer 63. 股票的最大利润
 * @Auther: Jack You
 * @Date: 2022/02/10/14:05
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int a = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if ((prices[j] - prices[i]) > a) {
                    a = prices[j] - prices[i];
                }
            }
        }
        return a;
    }

    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            }
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new MaxProfit().maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }
}
