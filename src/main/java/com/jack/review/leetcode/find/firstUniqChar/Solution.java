package com.jack.review.leetcode.find.firstUniqChar;

import org.apache.commons.lang3.StringUtils;

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
        if(StringUtils.isBlank(s)) {
            return ' ';
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int mid = left + right;
            if()
        }
        return '1';
    }
}
