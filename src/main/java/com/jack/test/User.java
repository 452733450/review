package com.jack.test;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: Jack You
 * @Date: 2022/12/13/17:10
 */
@Data
@Builder
public class User {

    private String name;

    private Integer age;
}
