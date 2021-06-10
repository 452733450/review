package com.jack.review.test.DesignPatterns.behavior.chainOfResponsible;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/01/25/13:41
 */
@Service
public interface ActivityService {

    int queryRemainedTimes();

    boolean isSupportedLocation(String location);

    boolean isNewUser(String user);
}
