package com.jack.review.test.DesignPatterns.behavior.chainOfResponsible;

import javax.annotation.Resource;

/**
 * @Description: 校验奖品是否已领完：
 * @Auther: Jack You
 * @Date: 2021/01/25/13:19
 */
public class LimitRuleHandler extends RuleHandler {
    @Resource
    private ActivityService activityService;

    public void apply(Context context) {
        /*int remainedTimes = activityService.queryRemainedTimes();*/ // 查询剩余奖品
        int remainedTimes = new ActivityServiceImpl().queryRemainedTimes();
        if (remainedTimes > 0) {
            if (this.getSuccessor() != null) {
                this.getSuccessor().apply(context);
            }
        } else {
            throw new RuntimeException("您来得太晚了，奖品被领完了");
        }
    }
}
