package com.jack.review.leetcode.dynamicProgramming;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/02/09/14:26
 */
public class Fib3 {
    /*快速矩阵幂是建立在数的快速幂的基础上的 比如a^11(数的快速幂)，根据快速幂的原理， 将11拆成1+2+8，也就是2^0 + 2^1 + 2^3，
    在观察11的二进制1011(从右到左观察)，说白了就是二进制和十进制间的转换，二进制到十进制，
    0不起作用 然后矩阵相乘，就是把上边的数字a换成矩阵A，然后再写一个函数，去计算两个矩阵的乘积 对于数字，初始化为1，
    对于矩阵呢，初始化当然是E了，也就是单位矩阵，因为A*E=A*/
    int mod = (int) 1e9 + 7;

    long[][] mul(long[][] a, long[][] b) {
        int r = a.length, c = b[0].length, z = b.length;
        long[][] ans = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < z; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= mod;
                }
            }
        }
        return ans;
    }

    public int fib(int n) {
        if (n <= 1) return n;
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
            if ((x & 1) != 0) ans = mul(mat, ans);
            mat = mul(mat, mat);
            x >>= 1;
        }
        return (int) (ans[0][0] % mod);
    }

    public static void main(String[] args) {
        // 0,1,1,2,3,5,8,13...
        System.out.println(new Fib3().fib(7));
    }
}
