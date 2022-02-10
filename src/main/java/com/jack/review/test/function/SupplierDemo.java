package com.jack.review.test.function;

import java.util.function.Supplier;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/29/13:16
 */
public class SupplierDemo {
    public static void main(String[] args) {
        String s = getString(() -> "你好");
        System.out.println(s);
        Integer i = getInteger(() -> 30);
        System.out.println(i);
    }

    //定义一个方法，返回一个整数数据
    private static Integer getInteger(Supplier<Integer> sup) {
        return sup.get();
    }

    //定义一个方法，返回一个字符串数据
    private static String getString(Supplier<String> sup) {
        return sup.get();
    }
}
