package com.jack.review.test.hutool.Func1;

import cn.hutool.core.lang.func.Func1;


import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/18/15:48
 */
public class func1 {
    public static void main(String[] args) {
        test("1");
    }

    private static void test(String str) {
        Func1<String, List<Integer>> func1 = new Test()::getStr;
        try {
            func1.call(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
