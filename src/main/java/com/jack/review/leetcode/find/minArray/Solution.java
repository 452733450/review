package com.jack.review.leetcode.find.minArray;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/27/10:14
 */
public class Solution {
    /*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

    给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
    请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  

    示例 1：
    输入：[3,4,5,1,2]
    输出：1

    示例 2：
    输入：[2,2,2,0,1]
    输出：0

    示例 3：
    输入：[0,1,2,3,4]
    输出：0*/

    /*2, 2, 2, 0, 1*/
    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        if (numbers.length == 0) {
            return -1;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        while (left < right) {
            int mid = left + right >> 1;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if(numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                // 2, 2, 2,| 0, 1,2
                // 关键点在于旋转的数组，头和尾相等时候，把右边相等的值去掉，这样才能找出最小的值在那半边
                -- right;
            }
        }
        return numbers[left];
    }

    public int minArray2(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public int minArray3(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (numbers[m] > numbers[r]) {
                l = m + 1;
            } else if (numbers[m] < numbers[r]) {
                r = m;
            } else {
                --r;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        /*System.out.println(minArray(new int[]{2,3, 4, 5, 1, 2}));
        System.out.println(minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minArray(new int[]{0}));
        System.out.println(minArray(new int[]{0, 1, 2, 3, 4}));

        System.out.println(minArray(new int[]{3, 1, 1}));*/
        System.out.println(minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
