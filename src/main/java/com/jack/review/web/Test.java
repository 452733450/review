package com.jack.review.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/04/29/16:19
 */
@RestController
public class Test {

    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }
}
