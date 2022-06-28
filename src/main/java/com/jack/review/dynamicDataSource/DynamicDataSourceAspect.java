package com.jack.review.dynamicDataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 切换数据源的切面
 */
@Component
@Aspect
@Order(1) //这是关键，要让该切面调用先于AbstractRoutingDataSource的determineCurrentLookupKey()
public class DynamicDataSourceAspect {

    @Pointcut("execution(* com.jack.review.dynamicDataSource.TestController.*.*(..))")
    public void pointcut() {
        System.out.println("[切面处理] >> 使用注解 @Pointcut 定义切点位置");
    }

    @Before("pointcut()")
    public void before(JoinPoint point) {
        try {
            //获得当前访问的class
            Class<?> className = point.getTarget().getClass();
            //获得访问的方法名
            String methodName = point.getSignature().getName();
            //得到方法的参数的类型
            Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
            String dataSource = "primary";
            try {
                // 得到访问的方法对象
                Method method = className.getDeclaredMethod(methodName, argClass);
                // 判断是否存在@DS注解
                if (method.isAnnotationPresent(DataSource.class)) {
                    DataSource annotation = method.getAnnotation(DataSource.class);
                    // 取出注解中的数据源名
                    dataSource = annotation.value();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            DataSourceContextHolder.setDataSource(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        DataSourceContextHolder.clearDataSource();
    }
}
