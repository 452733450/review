package com.jack.review.web;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/05/06/17:32
 */
public class Test2 {
    public static void main(String[] args) {
        /*System.out.println(toZero(new BigDecimal("0.1").negate()));
        System.out.println(toZero(new BigDecimal("0.01").negate()));*/
        // 32423142144214
        // https://blog.csdn.net/weixin_36242784/article/details/111889401  easyExcel各种注解
        // CONCAT_WS('-',customerName,RIGHT(cardNumber,6))

        System.out.println(checkMobilePhoneNum("123"));
    }

    private static BigDecimal toZero(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) < 0 && bigDecimal.compareTo(new BigDecimal("0.1").negate()) > 0 ? BigDecimal.ZERO : bigDecimal;
    }

    public static boolean checkMobilePhoneNum(String phoneNum) {
        String regex = "^(1[3-9]\\d{9}$)";
        if (phoneNum.length() == 11) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoneNum);
            return m.matches();
        }
        return false;
    }
}
