package com.jack.practice.middle.f147no54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/17/9:19
 */
public class Solution20220817 {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        int m = mat.length;
        if (m == 0) {
            return res;
        }
        int n = mat[0].length;
        circle(mat, 0, 0, m - 1, n - 1, res);
        return res;
    }

    private void circle(int[][] mat, int x1, int y1, int x2, int y2, List<Integer> res) {
        if(x1 > x2 || y1 > y2) return;
        if (x1 == x2) {
            // 这里没有= 就没有5，因为这里的y2是length - 1
            for (int i = y1; i <= y2; i++) {
                res.add(mat[x1][i]);
            }
            return;
        }
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                res.add(mat[i][y1]);
            }
            return;
        }

        for (int i = y1; i < y2; i++) {
            res.add(mat[x1][i]);
        }
        for (int i = x1; i < x2; i++) {
            res.add(mat[i][y2]);
        }
        for (int i = y2; i > y1; i--) {
            res.add(mat[x2][i]);
        }
        for (int i = x2; i > x1; i--) {
            res.add(mat[i][y1]);
        }
        circle(mat, x1 + 1, y1 + 1, x2 - 1, y2 - 1, res);
    }

    public static void main(String[] args) {
        Solution20220817 solution = new Solution20220817();
        List<Integer> res = solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println(res);
    }
}
