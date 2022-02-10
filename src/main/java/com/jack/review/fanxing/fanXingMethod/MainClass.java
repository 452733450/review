package com.jack.review.fanxing.fanXingMethod;

import static com.jack.review.fanxing.fanXingMethod.Test.genericMethod;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/11/15/14:31
 */
public class MainClass {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj = genericMethod(Class.forName("com.jack.review.fanxing.fanXingMethod.Test"));
        System.out.println(obj.getClass());
    }
}
