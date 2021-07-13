package com.jack.review.test.decimal;

import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/29/15:56
 */
public class subtract {
    private static BigDecimal subtract(BigDecimal b1, BigDecimal b2) {
        if(b1 == null && b2 == null){
            return null;
        }
        return b1 == null ? BigDecimal.ZERO : b1.subtract(b2 == null ? BigDecimal.ZERO : b2);
    }

    public static void main(String[] args) {
        System.out.println(subtract(BigDecimal.ONE,new BigDecimal("3")));
    }
}
