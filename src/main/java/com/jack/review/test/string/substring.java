package com.jack.review.test.string;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/23/13:10
 */
public class substring {
    /*Java中的String类提供了一个substring(int from, int to)方法用于截取字符串中位置为from到to-1位置的字符。

    因为字符串的字符位置是从0开始的，而substring(int from, int to)方法是前闭后开的，即[from, to)，可以理解为[from, to-1]。

    同时to是可以省略的（多态），to缺省的情况下为截取到字符串的最后一位。

    那么要截取字符串中的最后几个字符，就可以先获取字符串的长度，将字符串的长度-n作为substring()方法的第一参数，就能实现截取字符串最后的n个字符的效果。*/
    public static void main(String[] args) {
        String str = "i like yanggb";

        System.out.println(str.substring(str.length() - 6));
    }
}
