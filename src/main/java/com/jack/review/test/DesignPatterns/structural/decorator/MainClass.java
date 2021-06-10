package com.jack.review.test.DesignPatterns.structural.decorator;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/31/13:53
 */
public class MainClass {
    public static void main(String[] args) {
        // 首先，我们需要一个基础饮料，红茶、绿茶或咖啡
        Beverage beverage = new GreenTea();
        // 开始装饰
        beverage = new Lemon(beverage); // 先加一份柠檬
        beverage = new Mango(beverage); // 再加一份芒果

        System.out.println(beverage.getDescription() + " 价格：￥" + beverage.cost());

        /*如果我们需要 芒果-珍珠-双份柠檬-红茶：*/
        Beverage beverage1 = new Mango(new Pearl(new Lemon(new Lemon(new BlackTea()))));
        System.out.println(beverage1.getDescription() + "价格：￥" + beverage1.cost());
    }
}
