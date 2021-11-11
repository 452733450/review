package com.jack.review.test.trycatch;

import java.text.ParseException;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/26/13:16
 */
public class douyouReturn2 {
    /*在try中有return，在catch中新抛出异常，finally中有return
    如果catch块中捕获了异常, 并且在catch块中将该异常throw给上级调用者进行处理, 但finally中有return, 那么catch块中的throw就失效了, 上级方法调用者是捕获不到异常*/
    public static void main(String[] args) throws Exception {
        String result="";
        try {
            result = num();
        } catch (Exception e) {
            System.out.println("青天大老爷在此");
        }
        System.out.println(result);
    }
    public static String num() throws Exception {
        try{
            int b=4/0;
            return "总是异常，反正我又不会执行";
        }catch(Exception e){
            throw new Exception();
        }finally {
            return "用金钱蒙蔽你的双眼";
        }
    }
}
