package com.jack.test;

/**
 * @Description:
 * @Author: Jack You
 * @Date: 2023/01/09/10:07
 */
public class Test20230109 {
    public static void main(String[] args) {
        String str = "国a";
        String regex = ".*[a-zA-z].*";
        boolean b = str.matches(regex);
        System.out.println(b);

        String a = "中国1";
        String a1 = a.substring(0, a.length() - 1);
        System.out.println(a1);
 
         String REGEX = ".*[0-9]";
         boolean bool = a.matches(REGEX);
         boolean bool1 = a1.matches(REGEX);
         String tmp = a.substring(a.length() - 1);
        System.out.println(bool);
    }
}
