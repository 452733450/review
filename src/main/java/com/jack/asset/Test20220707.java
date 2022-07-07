package com.jack.asset;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/07/07/9:11
 */
public class Test20220707 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.1849");
        BigDecimal b = new BigDecimal("1.1946");
        BigDecimal c = new BigDecimal("1.1831");
        BigDecimal d = new BigDecimal("1.1531");
        BigDecimal e = new BigDecimal("1.1531");

        System.out.println(a.multiply(
                (b.subtract(c).add(d)).divide(e, 4,  RoundingMode.HALF_UP)
        ));
    }
}
