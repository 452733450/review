package com.jack.review.test.DesignPatterns.behavior.chainOfResponsible;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/01/25/13:40
 */
@Data
@Builder
public class Context implements Serializable {
    private String location;

    private String user;
}
