package com.jack.review.leetcode.dynamicProgramming;

// 斐波那契数列
public class Demo20220320a {
    public long fib(long n) {
        if (n <= 1) {
            return n;
        }
        long[][] mat = new long[][]{
                {1, 1},
                {1, 0}
        };
        long[][] ans = new long[][]{
                {1},
                {0}
        };
        long x = n - 1;
        while (x != 0) {
            if ((x & 1) != 0) {
                ans = mul(mat, ans);
            }
            mat = mul(mat, mat);
            x >>= 1;
        }
        return ans[0][0];
    }

    public long[][] mul(long[][] a, long[][] b) {
        int m = a.length, n = b[0].length, k = b.length;
        long[][] res = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    res[i][j] += a[i][l] * b[l][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13...
        System.out.println(new Demo20220320a().fib(7));
    }
}
