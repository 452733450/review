package com.jack.review.web;

import com.jack.review.service.MessageService;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/04/29/16:19
 */
@RestController
@RequestMapping("test1")
public class Test {

    @Resource
    private MessageService messageService;

    /*<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="messageService" class="com.jack.review.serviceImpl.MessageServiceImpl"/>
</beans>*/

    @GetMapping("/hello")
    public String hello(@Nullable @RequestBody String str){
        messageService.getMessage();
        return "hello world!";
    }
}
