package com.jack.review.test.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/07/13:43
 */
public class isNotBlank {
    // isEmpty 等价于 str == null || str.length == 0
    //isBlank  等价于 str == null || str.length == 0 || str.trim().length == 0
    public static void main(String[] args) {
        System.out.println(StringUtils.isNotBlank(" "));
        System.out.println(org.springframework.util.StringUtils.hasText(" "));
    }
}
