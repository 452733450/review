package com.jack.review.spring.annotion.customize;

import com.jack.review.util.ContextUtils;

import java.util.Map;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/23/17:10
 */
@TestGetBeansWithAnnotation
public class Test {
    public static void test() {
        // key:beanName, value:beanInstance
        Map<String, Object> map = ContextUtils.getBeansWithAnnotation(TestGetBeansWithAnnotation.class);
        for (Object object : map.values()) {
            Class<?> clazz = object.getClass();
            TestGetBeansWithAnnotation testGetBeansWithAnnotation = clazz.getAnnotation(TestGetBeansWithAnnotation.class);
            System.out.println(testGetBeansWithAnnotation);
        }
    }
}
