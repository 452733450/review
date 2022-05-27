package com.jack.practice.middle.no3;

import java.util.HashMap;

public class Test20220502 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        // abba
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Test20220502().lengthOfLongestSubstring("abbaca"));
    }
}
