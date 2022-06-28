package com.jack.review.dynamicDataSource;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/06/28/9:27
 */

import java.lang.annotation.*;

/**
 * 切换数据源的注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String value() default "primary";
}
