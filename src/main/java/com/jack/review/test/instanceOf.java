package com.jack.review.test;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/09/10:41
 */
public class instanceOf {
    /*instanceof是Java的一个二元操作符，和==，>，<是同一类东东。由于它是由字母组成的，所以也是Java的保留关键字。
    它的作用是测试它左边的对象是否是它右边的类的实例，返回boolean类型的数据。举个例子：*/

    public static void main(String[] args) {
        String s = "I AM an Object!";
        boolean isObject = s instanceof Object;
    }

}
