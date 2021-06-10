package com.jack.review.spring.properties;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/10/10:30
 */
public class profilesActive {
    /*如果是 Spring Boot 的话更简单，我们一般会创建 application.properties、application-dev.properties、application-prod.properties 等文件，
    其中 application.properties 配置各个环境通用的配置，application-{profile}.properties 中配置特定环境的配置，然后在启动的时候指定 profile：*/
//    java -Dspring.profiles.active=prod -jar JavaDoop.jar
//    如果是单元测试中使用的话，在测试类中使用 @ActiveProfiles 指定
}
