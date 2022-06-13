package com.jack.questions.basics;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/06/06/16:07
 */
public interface A {

    void test01();

    void test02();

    default void test03(){
        System.out.println("默认方法");
    }

    static void test04(){
        System.out.println("静态方法");
    }
}
