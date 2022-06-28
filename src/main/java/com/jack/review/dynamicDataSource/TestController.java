package com.jack.review.dynamicDataSource;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/06/28/9:39
 */
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class TestController {

    @RequestMapping("/local")
    @DataSource("local")
    String local() {
        System.out.println(DataSourceContextHolder.getDataSource());
        return "Hello World!";
    }

    @RequestMapping("/primary")
    @DataSource("primary")
    String primary() {
        System.out.println(DataSourceContextHolder.getDataSource());
        return "Hello World!";
    }
}
