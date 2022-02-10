package com.jack.review.test.decimal;

import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/08/02/16:27
 */
public class ToZero {
    private static BigDecimal toZero(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) < 0 && bigDecimal.compareTo(new BigDecimal("0.1").negate()) > 0 ? BigDecimal.ZERO : bigDecimal;
    }

    public static void main(String[] args) {
        System.out.println(toZero(new BigDecimal("-10000")));
    }
}
