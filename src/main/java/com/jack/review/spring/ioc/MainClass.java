package com.jack.review.spring.ioc;

import com.jack.review.service.MessageService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.SpringVersion;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/02/9:56
 */
public class MainClass {
    public static void main(String[] args) {
//        IOC 总体来说有两处地方最重要，一个是创建 Bean 容器，一个是初始化 Bean

        // 用我们的配置文件来启动一个 ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

        System.out.println(SpringBootVersion.getVersion());
        System.out.println(SpringVersion.getVersion());
        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        MessageService messageService = context.getBean(MessageService.class);
        // 这句将输出: hello world
        System.out.println(messageService.getMessage());

        BeanFactory beanFactory;
        // 能列在单子上的
        /*ApplicationContext 继承了 ListableBeanFactory，这个 Listable 的意思就是，通过这个接口，我们可以获取多个 Bean，
        大家看源码会发现，最顶层 BeanFactory 接口的方法都是获取单个 Bean 的*/
        ListableBeanFactory listableBeanFactory;

        // 分层的；等级体系的
        HierarchicalBeanFactory hierarchicalBeanFactory;

        // 有能力的；有才干的；容许……的；可以做（某事）的；综合性的；有资格的
        /*AutowireCapableBeanFactory 这个名字中的 Autowire 大家都非常熟悉，它就是用来自动装配 B ean 用的*/
        AutowireCapableBeanFactory autowireCapableBeanFactory;

        DefaultListableBeanFactory defaultListableBeanFactory;

        BeanDefinition beanDefinition;
        String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    }
}
