package com.jack.review.test.DesignPatterns.behavior.chainOfResponsible;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/26/14:19
 */
public class ActivityServiceImpl implements ActivityService {
    @Override
    public int queryRemainedTimes() {
        return 1;
    }

    @Override
    public boolean isSupportedLocation(String location) {
        return "上海".equals(location);
    }

    @Override
    public boolean isNewUser(String user) {
        return "Jack".equals(user);
    }
}
