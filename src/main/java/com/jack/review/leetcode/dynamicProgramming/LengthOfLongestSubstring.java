package com.jack.review.leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 剑指 Offer 48. 最长不含重复字符的子字符串
 * @Auther: Jack You
 * @Date: 2022/02/14/10:13
 */
public class LengthOfLongestSubstring {
    /*请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    示例 1:

    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
                 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    // 92.47%,5.02% 动态规划，双指针
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, j = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)), j);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j);
        }
        return res;
    }


    // 92.47%,15.06% 动态规划，哈希表
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = map.getOrDefault(s.charAt(i), -1);
            if (tmp < i - j) {
                tmp = tmp + 1;
            } else {
                tmp = i - j;
            }
            res = Math.max(res, tmp);
            map.put(s.charAt(i), i);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring3("abcabcbb"));
    }
}
