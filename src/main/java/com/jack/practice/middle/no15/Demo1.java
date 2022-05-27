package com.jack.practice.middle.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // k、i、j分别为第1、2、3位的数
        for (int k = 0; k < nums.length - 2; k++) {
            // 当 nums[k] > 0时，由于排过序 0 < nums[k] <= nums[i] <= nums[j] ，三个数都大于0，
            // 后续无需继续寻找，直接跳出循环
            if (nums[k] > 0) {
                return result;
            }
            // 题目要求，答案中不可以包含重复的三元组，
            // 从k的第二次循环开始，如果当前k的值和上一个相同，直接跳过本次查找，因为已经将nums[k - 1] 的所有组合加入到结果中
            //    当k上一次组合为 第一个和第二个数挨着且数相同时，对于-2、-2、-1、3、4
            //     找到 【-2】、【-2】、-1、3、【4】 以及【-2】、-2、【-1】、【3】、4
            //     那么本次k的 -2、【-2】、【-1】、【3】、4 已经包含在上次k找到的组合中了
            //
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // 第二个数i和第三个数j分别指向 k右侧的 最左面和最右面，表示k右侧 最小的数和最大的数，去寻找i+j=-nums[k]的数
            int i = k + 1, j = nums.length - 1, sum = -nums[k];
            // 一直遍历到双指针ij相遇
            while (i < j) {
                if (nums[i] + nums[j] == sum) {
                    // 如果找到了放到结果中
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 如果后面的值和前面的值相同则多移动一次，防止包含重复的三元组
                    // 并且下面的两个跳过相同的值的while判断不要放到第一层for循环的地方来做，
                    // 因为找到结果的情况毕竟是少数，要是放在外面反而每一次循环都要多一次判断，经测试运行速度也确实慢了
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    // i、【待寻找的值】、j
                    // 双指针往里移动继续寻找，表示排除掉i与【待寻找的值】的组合，以及j与【待寻找的值】的组合
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < sum) {
                    // i、【待寻找的值】、j
                    // 如果 i+j的值小了，说明要想办法让i+j大一点来寻找与sum相当的值，而j又是k右侧待寻找的最大的数，所以就让k右侧待寻找的最小的i大一点
                    // 即让左指针(第二个数i)向右移动，也就是排除掉 i与【待寻找的值】的组合，
                    // 因为i与比【待寻找的值】都大的j 组合都小了，那么i与【待寻找的值】的组合肯定更小了
                    i++;
                } else {
                    // 与上面类似，如果i+j的值大了，让i+j小一点，让右指针j左移，同时也表示排除j与【待寻找的值】的组合
                    // 另在这个地方j不用跳过j-1相同的值，因为就算下次循环nums[j-1]与nums[j]的值相同，所以依然不是目标值，不会将重复三元组放入结果中
                    // 并且由于nums[j]与nums[j-1]的值相同的情况毕竟是少数，但是如果加了，反而每一次不相同的情况都要多一次比较
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Demo1().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list.size());
    }

}
