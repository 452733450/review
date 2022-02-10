package com.jack.review.test.string;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/20/10:09
 */
public class Test {

    private static void changeStr(String str){
        str = "welcome";
    }

    public static void main(String[] args) {
        String str = "1234";
        changeStr(str);
        System.out.println(str);
    }
}
