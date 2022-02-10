package com.jack.review.test.test;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/20/10:42
 */
public class Test01 {
    public void test(){
        String aStr = " One ";
        String bStr = aStr;
        bStr = aStr.trim();
        System.out.println("["+aStr+","+bStr+"]");
    }

    public static void main(String[] args) {
        new Test01().test();
    }
}
