package com.jack.review.test.DesignPatterns.behavior.chainOfResponsible;

/**
 * @Description: 首先，我们要定义流程上节点的基类
 * @Auther: Jack You
 * @Date: 2021/01/25/13:18
 */
public abstract class RuleHandler {
    // 后继节点
    protected RuleHandler successor;

    public abstract void apply(Context context);

    public void setSuccessor(RuleHandler successor) {
        this.successor = successor;
    }

    public RuleHandler getSuccessor() {
        return successor;
    }
}
