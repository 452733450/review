package com.jack.review.test.DesignPatterns.behavior.chainOfResponsible;

import javax.annotation.Resource;

/**
 * @Description: 校验用户所在地区是否可以参与：
 * @Auther: Jack You
 * @Date: 2021/01/25/13:18
 */
public class LocationRuleHandler extends RuleHandler {
    @Resource
    private ActivityService activityService;

    public void apply(Context context) {
        /*boolean allowed = activityService.isSupportedLocation(context.getLocation());*/
        boolean allowed = new ActivityServiceImpl().isSupportedLocation(context.getLocation());
        if (allowed) {
            if (this.getSuccessor() != null) {
                this.getSuccessor().apply(context);
            }
        } else {
            throw new RuntimeException("非常抱歉，您所在的地区无法参与本次活动");
        }
    }
}
