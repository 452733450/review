package com.jack.review.test.list;

import lombok.Data;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/28/9:25
 */
@Data
public class User {
    private Integer customerId;
    private Integer productId;

    public User(Integer customerId, Integer productId) {
        this.customerId = customerId;
        this.productId = productId;
    }
}
