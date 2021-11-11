package com.jack.review.test.decimal;

import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/09/23/13:06
 */
public class divide {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("-0.1");
        BigDecimal b2 = new BigDecimal("0.7");
        System.out.println(b1.divide(b2,4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100)));
    }
}
