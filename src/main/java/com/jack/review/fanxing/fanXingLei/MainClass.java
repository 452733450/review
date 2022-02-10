package com.jack.review.fanxing.fanXingLei;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/11/15/13:32
 */
public class MainClass {
    public static void main(String[] args) {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_vlaue");

        System.out.println("泛型测试, key is " + genericInteger.getKey());
        System.out.println("泛型测试,key is " + genericString.getKey());
    }

}
