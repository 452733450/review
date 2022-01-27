package com.jack.review.leetcode.test;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/12/01/15:03
 */
public class ErFenFa {

    boolean check(int x) {
        return true;
    }

    int search(int left, int right) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
