package com.jack.questions.spring;


//因为我用的是Spring Boot 3.0 . 如果是2.0需要改成javax.annotation.PostConstruct

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class ExampleBean implements InitializingBean {
    private String message;

    public ExampleBean() {
        System.out.println("构造函数执行");
    }

    @PostConstruct
    public void postConstructMethod() {

        System.out.println("postConstructMethod执行");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet执行");
    }

    public void customInitMethod() {
        System.out.println("InitMethod执行");
    }
}
