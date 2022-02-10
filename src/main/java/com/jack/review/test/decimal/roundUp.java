package com.jack.review.test.decimal;


import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/10/28/11:10
 */
public class roundUp {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.6666");
        System.out.println(b1.setScale(2,BigDecimal.ROUND_UP));
        System.out.println(b1.setScale(2,BigDecimal.ROUND_DOWN));
    }

}
