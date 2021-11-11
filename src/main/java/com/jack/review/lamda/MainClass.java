package com.jack.review.lamda;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/12/14:41
 */
public class MainClass {
    public static void main(String[] args) {
        Test.test(1, () -> new SelectImpl().findById(1));
        Thread thread = new Thread();
        thread.run();
    }
}
