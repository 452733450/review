package com.jack.review.test.threadLocal;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/25/10:25
 */
@Data
@Builder
public class User implements Serializable {

    private String username;

    private Integer age;
}
