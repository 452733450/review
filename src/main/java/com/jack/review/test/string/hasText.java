package com.jack.review.test.string;

import org.springframework.util.StringUtils;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/15/13:37
 */
public class hasText {
    /*StringUtils.hasText():如果字符序列不为 null 值,并且字符序列的长度大于 0 ,并且不含有空白字符序列,则返回 true*/
    /*只要字符串中有一个字符不为空，则为true*/

    public static void main(String[] args) {
        boolean b1 = StringUtils.hasText("");
        System.out.println(b1);

        boolean b2 = StringUtils.hasText(" ");
        System.out.println(b2);

        boolean b3 = StringUtils.hasText("hello");
        System.out.println(b3);

        boolean b4 = StringUtils.hasText("hel lo");
        System.out.println(b4);
    }


}
