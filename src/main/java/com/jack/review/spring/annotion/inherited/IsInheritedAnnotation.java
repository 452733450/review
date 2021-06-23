package com.jack.review.spring.annotion.inherited;

import java.lang.annotation.*;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/23/16:27
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface IsInheritedAnnotation {
}
