package com.jack.practice.middle.f147no54;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/16/14:27
 */
public class Solution {
    // 时间复杂度：O(n * m)
    // 空间复杂度：O(1)
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        circle(mat, 0, 0, m - 1, n - 1, ans);
        return ans;
    }

    // 遍历 以 (x1, y1) 作为左上角，(x2, y2) 作为右下角形成的「圈」
    void circle(int[][] mat, int x1, int y1, int x2, int y2, List<Integer> ans) {
        if (x2 < x1 || y2 < y1) return;
        // 只有一行时，按「行」遍历
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) ans.add(mat[x1][i]);
            return;
        }
        // 只有一列时，按「列」遍历
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) ans.add(mat[i][y2]);
            return;
        }
        // 遍历当前「圈」
        for (int i = y1; i < y2; i++) ans.add(mat[x1][i]);
        for (int i = x1; i < x2; i++) ans.add(mat[i][y2]);
        for (int i = y2; i > y1; i--) ans.add(mat[x2][i]);
        for (int i = x2; i > x1; i--) ans.add(mat[i][y1]);
        // 往里收一圈，继续遍历
        circle(mat, x1 + 1, y1 + 1, x2 - 1, y2 - 1, ans);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        System.out.println(res);
    }
}
