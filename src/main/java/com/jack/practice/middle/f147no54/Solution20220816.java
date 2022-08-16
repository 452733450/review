package com.jack.practice.middle.f147no54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/16/15:49
 */
public class Solution20220816 {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        int m = mat.length;
        if (m == 0) {
            return res;
        }
        int n = mat[0].length;

        dfs(mat, 0, 0, m - 1, n - 1, res);
        return res;
    }

    private void dfs(int[][] mat, int x1, int y1, int x2, int y2, List<Integer> res) {
        if (x2 < x1 || y2 < y1) return;
        // 只有一列时，按「列」遍历
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) res.add(mat[x1][i]);
            return;
        }
        // 只有一行时，按「行」遍历
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) res.add(mat[i][y2]);
            return;
        }


        // 遍历圈
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

        dfs(mat, x1 + 1, y1 + 1, x2 - 1, y2 - 1, res);
    }

    public static void main(String[] args) {
        Solution20220816 solution = new Solution20220816();
        List<Integer> res = solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println(res);
    }
}
