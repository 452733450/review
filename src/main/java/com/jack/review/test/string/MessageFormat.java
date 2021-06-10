package com.jack.review.test.string;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/02/9:33
 */
public class MessageFormat {
    public static void main(String[] args) {

        String str = java.text.MessageFormat.format("你好:{0}", "Jack");
        System.out.println(str);
    }


}
