package com.jack.review.test.jkd8;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/23/10:50
 */
public interface MyInterface {

    // static修饰符定义静态方法
    static void staticMethod() {
        System.out.println("接口中的静态方法");
    }

    // default修饰符定义默认方法
    default void defaultMethod() {
        System.out.println("接口中的默认方法");
    }

    void abstractMethod();
}
