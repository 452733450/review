package com.jack.review.web;

import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/06/17:32
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(toZero(new BigDecimal("0.1").negate()));
        System.out.println(toZero(new BigDecimal("0.01").negate()));
        // 32423142144214
        // https://blog.csdn.net/weixin_36242784/article/details/111889401  easyExcel各种注解
        // CONCAT_WS('-',customerName,RIGHT(cardNumber,6))
    }

    private static BigDecimal toZero(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) < 0 && bigDecimal.compareTo(new BigDecimal("0.1").negate()) > 0 ? BigDecimal.ZERO : bigDecimal;
    }
}
