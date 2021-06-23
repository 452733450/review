package com.jack.review.serviceImpl;

import com.jack.review.service.MessageService;
import com.jack.review.spring.annotion.customize.Test;
import com.jack.review.spring.annotion.customize.TestGetBeansWithAnnotation;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/02/9:53
 */
@TestGetBeansWithAnnotation
@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        Test.test();
        return "hello world";
    }


}
