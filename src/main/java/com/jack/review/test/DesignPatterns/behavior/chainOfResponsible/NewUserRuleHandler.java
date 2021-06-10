package com.jack.review.test.DesignPatterns.behavior.chainOfResponsible;

import javax.annotation.Resource;

/**
 * @Description: 校验用户是否是新用户
 * @Auther: Jack You
 * @Date: 2021/01/25/13:20
 */
public class NewUserRuleHandler extends RuleHandler {
    @Resource
    private ActivityService activityService;

    public void apply(Context context) {
        /*boolean isNewUser = activityService.isNewUser(context.getUser());*/
        boolean isNewUser = new ActivityServiceImpl().isNewUser(context.getUser());
        if (isNewUser) {
            // 如果有后继节点的话，传递下去
            if (this.getSuccessor() != null) {
                this.getSuccessor().apply(context);
            }
        } else {
            throw new RuntimeException("该活动仅限新用户参与");
        }
    }
}
