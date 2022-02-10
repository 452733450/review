package com.jack.review.test.function;

import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/30/10:28
 */
public class MainClass {
    public static void main(String[] args) {
        test3();
    }

    /*Consumer<T>
    提供一个T类型的输入参数，不返回执行结果*/
    private static void test1(){
        Function<String, String> function = a -> a + " Jack!";
        System.out.println(function.apply("Hello")); // Hello Jack!
    }

    private static void test2(){
        /*default  Consumer<T>  andThen(Consumer<? super T> after)
        返回一个组合函数，after将会在该函数执行之后应用*/
        Function<String, String> function = a -> a + " Jack!";
        Function<String, String> function1 = a -> a + " Bob!";
        String greet = function.andThen(function1).apply("Hello");
        System.out.println(greet); // Hello Jack! Bob!
    }


    /*BiConsumer<T,U>
    提供两个自定义类型的输入参数，不返回执行结果*/
    private static void test3(){
        StringBuilder sb = new StringBuilder();
        BiConsumer<String, String> biConsumer = (a, b) -> {
            sb.append(a);
            sb.append(b);
        };
        biConsumer.accept("Hello ", "Jack!");
        System.out.println(sb.toString());	// Hello Jack!

        BiConsumer<String, String> biConsumer1 = (a, b) -> {
            System.out.println(a + b);
        };
        biConsumer.andThen(biConsumer1).accept("Hello", " Jack!"); // Hello Jack!
    }

    private static void test4(){

    }
}
