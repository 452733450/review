package com.jack.review.leetcode.bisectionMethod;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/21/10:53
 */
public class Solution3 {
    /*在 D 天内送达包裹的能力
    传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
    传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
    返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。

    示例 1：
    输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
    输出：15
    解释：
    船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
    第 1 天：1, 2, 3, 4, 5
    第 2 天：6, 7
    第 3 天：8
    第 4 天：9
    第 5 天：10
    请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。

    示例 2：
    输入：weights = [3,2,2,4,1,4], D = 3
    输出：6
    解释：
    船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
    第 1 天：3, 2
    第 2 天：2, 4
    第 3 天：1, 4
    提示：
            •1 <= D <= weights.length <= 50000
            •1 <= weights[i] <= 500
    解法：
    注：一般对于求最值/极值问题，可以考虑使用二分枚举，找到值的边界点。
    对于本题，我们应用模板 1，二分枚举运载能力 capacity，找到能在 D 天内送达的最小运载即可。*/

    public static int shipWithinDays(int[] weights, int days) {
        int left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean check(int[] weights, int days, int capacity) {
        int cnt = 1, t = 0; // t:一天已运载的重量
        for (int w : weights) {
            if (w > capacity) {
                // 一个包裹的重量大于运载量，说明运载量过小，这时要增加左边界，增大运载量，left = mid + 1,capacity = mid = (left + right) >> 1,运载量增大
                return false;
            }
            if (t + w <= capacity) {
                // 一天已运载的量加一个包裹的重量小于等于运载量
                t += w;
            } else {
                // 一天已运载的量加一个包裹的重量大于等于运载量，这时就不能运完，要把这次的运载量w放到下一天，这时候已运载量= 这次的运载量，同时天数+1
                t = w;
                // 需要的天数加1
                ++cnt;
            }
        }
        return cnt <= days;
    }

    public static void main(String[] args) {
        int i = shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        System.out.println(i);
    }
}
