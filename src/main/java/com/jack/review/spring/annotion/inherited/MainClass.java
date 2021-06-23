package com.jack.review.spring.annotion.inherited;

import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/23/16:30
 */
public class MainClass {
    public static void testInherited() {
        Annotation[] annotations = MyInheritedClass.class.getAnnotations();
        Assert.isTrue(Arrays.stream(annotations).anyMatch(l -> l.annotationType().equals(IsInheritedAnnotation.class)), "获取到了父类的可继承注解");
        Assert.isTrue(Arrays.stream(annotations).noneMatch(l -> l.annotationType().equals(NoInheritedAnnotation.class)), "获取不到父类的不可继承注解");
    }

    public static void main(String[] args) {
        testInherited();
    }
}
