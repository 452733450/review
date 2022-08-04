package com.jack.practice.simple.no415;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/08/04/10:05
 */
public class Test20220804 {
    public static void main(String[] args) {
        String str = "123";
        int a = str.charAt(1) - '0';
        System.out.println(a);

        BigDecimal b1 = new BigDecimal("1.0100");
        BigDecimal b2 = new BigDecimal("1.0154");
        BigDecimal b3 = new BigDecimal("1.0100");
        BigDecimal b4 = b1.setScale(4, RoundingMode.HALF_UP).multiply(b2).divide(b3, 4, RoundingMode.HALF_UP);
        System.out.println(b4);
    }
}
