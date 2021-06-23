package com.jack.review.test.string;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/15/13:18
 */
public class tokenizeToStringArray {
    /*将字符串按照指定的字符转换成String[]数组，如字符串中不包含指定字符，则将整个字符串放进数组。
    如指定字符有多个，是分别按单个字符来切割的。 字符串： "made,in;china"     指定字符： ",;"
    返回数组：[made, in, china]*/
    public static final String MULTI_VALUE_ATTRIBUTE_DELIMITERS = ",; ";

    public static void test() {
        String nameAttr = "made,in;china";
        String flag = MULTI_VALUE_ATTRIBUTE_DELIMITERS;
        String[] nameArr = StringUtils.tokenizeToStringArray(nameAttr, MULTI_VALUE_ATTRIBUTE_DELIMITERS);
        System.out.println(Arrays.toString(nameArr));
    }

    public static void test2() {
        String nameAttr = "madeinchina";
        String flag = MULTI_VALUE_ATTRIBUTE_DELIMITERS;
        String[] nameArr = StringUtils.tokenizeToStringArray(nameAttr, MULTI_VALUE_ATTRIBUTE_DELIMITERS);
        System.out.println(Arrays.toString(nameArr));
    }

    public static void main(String[] args) {
        test();
        test2();
    }
}
