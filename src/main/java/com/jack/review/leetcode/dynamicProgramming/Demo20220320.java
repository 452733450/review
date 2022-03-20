package com.jack.review.leetcode.dynamicProgramming;

// 斐波那契数列
public class Demo20220320 {
    public int fib(int n) {
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
        int x = n - 1;
        while (x != 0) {
            if ((x & 1) != 0) {
                ans = mul(mat, ans);
            }
            mat = mul(mat, mat);
            x >>= 1;

        }
        return (int) ans[1][0];
    }

    public long[][] mul(long[][] a, long[][] b) {
        int r = a.length, c = b[0].length, z = b.length;
        long[][] res = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int n = 0; n < z; n++) {
                    res[i][j] += a[i][n] * b[n][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13...
        System.out.println(new Demo20220320().fib(7));
    }
}
