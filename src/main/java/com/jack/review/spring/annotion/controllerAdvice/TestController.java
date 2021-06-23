package com.jack.review.spring.annotion.controllerAdvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/21/15:12
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
    @GetMapping("/hello")
    public String hello(Model model) {
        Map<String, Object> map = model.asMap();
        log.info("map:{}",map);
        int i = 1 / 0;
        return "hello controller advice";
    }

    @PostMapping("/book")
    public void addBook(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author) {
        /*这个时候，添加操作就会有问题，因为两个实体类都有一个 name 属性，从前端传递时 ，无法区分。
        此时，通过 @ControllerAdvice 的全局数据预处理可以解决这个问题*/
        System.out.println(book);
        System.out.println(author);
    }
}
