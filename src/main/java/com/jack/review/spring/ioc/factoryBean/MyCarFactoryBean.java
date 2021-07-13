package com.jack.review.spring.ioc.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.StringUtils;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/09/14:19
 */
public class MyCarFactoryBean implements FactoryBean<Car> {
    private String make;
    private int year;

    public void setMake(String m) {
        this.make = m;
    }

    public void setYear(int y) {
        this.year = y;
    }

    @Override
    public Car getObject() {
        // 这里我们假设 Car 的实例化过程非常复杂，反正就不是几行代码可以写完的那种
        Car cb = new Car();

        if (year != 0) cb.setYear(this.year);
        if (StringUtils.hasText(this.make)) cb.setMake(this.make);
        return cb;
    }

    public Class<Car> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return false;
    }
}

/*<bean class = "com.javadoop.MyCarFactoryBean" id = "car">
<property name = "make" value ="Honda"/>
<property name = "year" value ="1984"/>
</bean>
<bean class = "com.javadoop.Person" id = "josh">
<property name = "car" ref = "car"/>
</bean>*/
/*
看到不一样了吗？id 为 “car” 的 bean 其实指定的是一个 FactoryBean，不过配置的时候，我们直接让配置 Person 的 Bean 直接依赖于这个 FactoryBean 就可以了。中间的过程 Spring 已经封装好了。
这个时候，其实我们的思路也很简单，把 MyCarFactoryBean 看成是一个简单的 Bean 就可以了，不必理会什么 FactoryBean，它是不是 FactoryBean 和我们没关系
*/
