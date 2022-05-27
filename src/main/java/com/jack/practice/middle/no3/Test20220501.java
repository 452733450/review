package com.jack.practice.middle.no3;

import java.util.HashMap;

public class Test20220501 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //最长子串长度
        int max = 0;
        //滑动窗口左下标，i相当于滑动窗口右下标
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
            if (map.containsKey(s.charAt(i))) {
                //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
                //map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
                //因为map得到的那个索引下标不一定在滑动窗口内，如果去掉的话abba这种的就不可以啦
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //再更新map中a映射的下标
            map.put(s.charAt(i), i);
            //比较两个参数的大小
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}
