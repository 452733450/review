package com.jack.review.leetcode.DoublePointer;

/**
 * @Description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @Auther: Jack You
 * @Date: 2022/02/16/14:51
 */

/*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
        示例：
        输入：nums = [1,2,3,4]
        输出：[1,3,2,4]
        注：[3,1,2,4] 也是正确的答案之一。*/
public class Exchange {
    public int[] exchange(int[] nums) {

        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            // i从左往右找第一个偶数， j从右往左找第一个奇数，交换位置
            while ((nums[i] & 1) != 0 && i < j) {
                i++;
            }

            while ((nums[j] & 1) == 0 && i < j) {
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] res = new Exchange().exchange(arr);
        System.out.println(res.length);
    }
}
