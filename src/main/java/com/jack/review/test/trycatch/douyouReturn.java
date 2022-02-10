package com.jack.review.test.trycatch;

import java.text.ParseException;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/26/13:16
 */
public class douyouReturn {
    /*在try和catch中有return，finally中也有return
    try或catch中return后面的代码会执行，但最终返回的结果为finally中return的值，需要注意的是try或catch中return后面的代码会执行，只是存起来了，并没有返回，让finally捷足先登先返回了*/
    public static int num=1;
    public static void main(String[] args) throws ParseException {
        int result;
        result = num();
        System.out.println(result);//输出结果为1003
        System.out.println(num);//输出结果为1001
    }
    private static int num() {
        try{
            int b=4/0;
            return num = num+1000;
        }catch(Exception e){
            return num = num+1000;
        }finally {
            return num+2;
        }
    }
}
