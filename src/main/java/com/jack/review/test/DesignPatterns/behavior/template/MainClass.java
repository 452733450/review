package com.jack.review.test.DesignPatterns.behavior.template;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/26/13:55
 */
public class MainClass {
    public static void main(String[] args) {
        AbstractTemplate t = new ConcreteTemplate();
        // 调用模板方法
        t.templateMethod();
    }
}
