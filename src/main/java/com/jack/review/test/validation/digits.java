package com.jack.review.test.validation;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 限制小数位数为2位
 * @Auther: Jack You
 * @Date: 2021/05/13/11:05
 */
public class digits {

    private static final String REG = "^(([1-9]\\d*)|([0]))(\\.(\\d){0," + "digits})?$";

    public static boolean isNumber(String str) {
        int digits  = 2;
        Pattern pattern = Pattern.compile(REG.replace("digits", String.valueOf(digits)));
        Matcher match = pattern.matcher(str);
        return match.matches();
    }

    public static void main(String[] args) {

        boolean a = isNumber("1");
        boolean b = isNumber("1.0");
        boolean c = isNumber("1.22");
        boolean d = isNumber("1.222");
        boolean e = isNumber("222.22");
        boolean f = isNumber("0.01");
        boolean g = isNumber("0.001");
        boolean h = isNumber("");
        boolean i = isNumber("1.");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);

        Double amountD = Double.parseDouble("1.");
        Long fronezAmount = BigDecimal.valueOf(amountD * 100).toBigInteger().longValue();
        System.out.println(amountD);
        System.out.println(fronezAmount);
    }
}
