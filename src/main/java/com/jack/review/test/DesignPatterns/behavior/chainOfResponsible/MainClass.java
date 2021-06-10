package com.jack.review.test.DesignPatterns.behavior.chainOfResponsible;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/01/25/13:19
 */
public class MainClass {
    public static void main(String[] args) {
        /*责任链通常需要先建立一个单向链表，然后调用方只需要调用头部节点就可以了，后面会自动流转下去。
        比如流程审批就是一个很好的例子，只要终端用户提交申请，根据申请的内容信息，自动建立一条责任链，然后就可以开始流转了。

        有这么一个场景，用户参加一个活动可以领取奖品，但是活动需要进行很多的规则校验然后才能放行，
        比如首先需要校验用户是否是新用户、今日参与人数是否有限额、全场参与人数是否有限额等等。设定的规则都通过后，才能让用户领走奖品。*/


        /*代码其实很简单，就是先定义好一个链表，然后在通过任意一节点后，如果此节点有后继节点，那么传递下去。

        至于它和我们前面说的用一个 List 存放需要执行的规则的做法有什么异同，留给读者自己琢磨吧。*/
        RuleHandler newUserHandler = new NewUserRuleHandler();
        RuleHandler locationHandler = new LocationRuleHandler();
        RuleHandler limitHandler = new LimitRuleHandler();

        // 假设本次活动仅校验地区和奖品数量，不校验新老用户
        newUserHandler.setSuccessor(locationHandler);
        locationHandler.setSuccessor(limitHandler);

        Context context = new Context("上海1", "Jack");
        locationHandler.apply(context);
    }
}
