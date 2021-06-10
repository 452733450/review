package com.jack.review.test.DesignPatterns.behavior.state;

import lombok.Data;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/26/16:36
 */
@Data
public class Context {
    private State state;
    private String name;

    public Context(String name) {
        this.name = name;
    }
}
