package com.jack.review.web;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @Description: 常用的函数式接口Function接口apply方法
 * @Auther: Jack You
 * @Date: 2021/04/29/16:50
 */
public class FunctionTest {
    /*
    java.util.function.Function<T, R>：接口用来根据一个类型的数据得到另一个类型的数据，
        前者称为前置条件，后者称为后置条件。
    Function接口中最主要的抽象方法为：R apply(T t)，根据类型T的参数获取类型R的结果。
        使用的场景例如：将String类型转换为Integer类型。
 */
    public static void change(String s, Function<String, Integer> fun) {
//        Integer in = fun.apply(s);
        int in = fun.apply(s); // 自动拆箱 Integer -> int
        System.out.println(in);
    }

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);

       Long[] arr =  list.toArray(new Long[0]);;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

        // 定义一个字符串数组
        String s = "123456789";
        // 调用change方法，传递字符串类型的整数，和Lambda表达式
        // 把字符串类型的整数，转换为Integer类型的整数返回
        /*change(s, (String str) -> {
            // 把字符串类型的整数，转换为Integer类型的整数返回
            return Integer.parseInt(str);
        });*/

        // 优化Lambda表达式
        /*change(s, str -> Integer.parseInt(str));*/

        change(s, Integer::parseInt);

        // Function.identity() 一个总是返回输入参数的函数
    }
}
