package com.jack.review.leetcode.dynamicProgramming;

import java.math.BigDecimal;

/**
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @Auther: Jack You
 * @Date: 2022/02/09/16:39
 */
public class NumWays {
    int mod = (int) 1e9 + 7;
    public int numWays(int n) {
        // 0,1,2,3,4,5
        // 1,1,2,3,5,8
        // 0,1,1,2,3,5,8,13...
        if (n <= 1) {
            return 1;
        }
        long[][] mat = {
                {1, 1},
                {1, 0}
        };
        long[][] ans = {{1}, {0}};

        int x = n;
        while (x != 0) {
            if ((x & 1) != 0) {
                ans = mul(mat, ans);
            }
            mat = mul(mat, mat);
            x >>= 1;
        }
        return (int) ans[0][0] % mod;
    }

    private long[][] mul(long[][] a, long[][] b) {
        // a的行数
        int c = a.length,
                // b的列数
                d = b[0].length,
                // b的行数
                e = b.length;

        // a 乘b得到一个行数=a行数，列数=b列数的新矩阵
        long[][] ans = new long[c][d];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < e; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= mod;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumWays().numWays(5));
    }
}
