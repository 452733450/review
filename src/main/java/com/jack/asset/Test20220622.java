package com.jack.asset;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/06/22/14:30
 */
public class Test20220622 {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("00.3456");
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        System.out.println(percent.format(b.doubleValue()));
        System.out.println(b.toPlainString());
        System.out.println(b.toString());
        System.out.println(b.toEngineeringString());
    }
}
