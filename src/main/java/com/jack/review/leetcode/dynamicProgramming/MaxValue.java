package com.jack.review.leetcode.dynamicProgramming;

/**
 * @Description: 剑指 Offer 47. 礼物的最大价值
 * @Auther: Jack You
 * @Date: 2022/02/10/17:45
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }


    public int maxValue2(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][column - 1];
    }


    public int maxValue3(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[row - 1][column - 1];
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        /*System.out.println(new MaxValue().maxValue(arr));*/
        System.out.println(new MaxValue().maxValue3(arr));
    }
}
