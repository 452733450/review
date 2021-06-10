package com.jack.review.serviceImpl;

import com.jack.review.service.MessageService;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/02/9:53
 */
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "hello world";
    }
}
