package com.jack.review.leetcode.find.firstUniqChar;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/01/27/14:15
 */
public class Solution {
    /*在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

    示例 1:
    输入：s = "abaccdeff"
    输出：'b'

    示例 2:
    输入：s = ""
    输出：' '*/
    public char firstUniqChar(String s) {
        if (StringUtils.isBlank(s)) {
            return ' ';
        }
        return '1';
    }

    public char firstUniqChar2(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static char firstUniqChar3(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        for (char c : chars) {
            if (count[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar3("abaccdeff"));

        int[] arr = new int[]{1,2,3};
        for (int i :arr){
            arr[i]++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public char firstUniqChar4(String s) {
        int n;
        if ((n = s.length()) == 0) return ' ';
        int[] counter = new int[26];
        for (int i = 0; i < n; ++i) {
            int index = s.charAt(i) - 'a';
            ++counter[index];
        }
        for (int i = 0; i < n; ++i) {
            int index = s.charAt(i) - 'a';
            if (counter[index] == 1) return s.charAt(i);
        }
        return ' ';
    }

}
