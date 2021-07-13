package com.jack.review.spring.ioc.factoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/09/14:28
 */
@Configuration
public class CarConfiguration {
    @Bean
    public MyCarFactoryBean carFactoryBean() {
        MyCarFactoryBean cfb = new MyCarFactoryBean();
        cfb.setMake("Honda");
        cfb.setYear(1984);
        return cfb;
    }

    @Bean
    public Person aPerson() {
        Person person = new Person();
        // 注意这里的不同
        person.setCar(carFactoryBean().getObject());
        return person;
    }
}
