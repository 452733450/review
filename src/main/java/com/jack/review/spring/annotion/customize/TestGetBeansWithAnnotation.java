package com.jack.review.spring.annotion.customize;

import java.lang.annotation.*;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/23/16:10
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestGetBeansWithAnnotation {
}
