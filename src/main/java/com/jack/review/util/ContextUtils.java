package com.jack.review.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author zhangwei@meix.com
 * @date 2020/11/9
 */
@Slf4j
@Component
public class ContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T> T getBean(Class<T> clazz) {
        if (applicationContext == null) {
            throw new RuntimeException("applicationContext获取失败");
        }
        return applicationContext.getBean(clazz);
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        if (applicationContext == null) {
            throw new RuntimeException("applicationContext获取失败");
        }
        return applicationContext.getBeansWithAnnotation(annotationType);
    }
}
