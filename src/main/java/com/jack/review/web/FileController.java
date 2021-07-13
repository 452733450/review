package com.jack.review.web;

import com.jack.review.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/07/06/11:05
 */
@RestController
@RequestMapping("file")
@Validated
public class FileController {

    @PostMapping("test")
    public void test(@RequestParam(value = "file", required = false) MultipartFile file, @Valid User user){
        int i = 1/2;
        System.out.println(i);
    }
}
