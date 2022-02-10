package com.jack.review.leetcode.bisectionMethod;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/21/10:05
 */
public class Solution2 {
    /*珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
    珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
    珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
    返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。*/

    /*注：一般对于求最值/极值问题，可以考虑使用二分枚举，找到值的边界点。*/
    public static int minEatingSpeed(int[] piles, int h) {
        int mx = 0;
        for (int pile : piles) {
            mx = Math.max(mx, pile);
        }
        int left = 1, right = mx;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int s = 0;
            for (int pile : piles) {
                s += (pile + mid - 1) / mid;
            }
            if (s <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        /*输入: piles = [3,6,7,11], H = 8
        输出: 4

        输入: piles = [30,11,23,4,20], H = 5
        输出: 30

        输入: piles = [30,11,23,4,20], H = 6
        输出: 23*/
    }
}
