package com.jack.review.test.decimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2021/06/22/9:26
 */
public class decimalFormat {
    /*DecimalFormat decimalFormat = new DecimalFormat("0.00%");*/
    public static String format2(BigDecimal data) {
        DecimalFormat df = null;
        BigDecimal rs = data.subtract(BigDecimal.ONE);
        if(rs.compareTo(BigDecimal.ZERO) < 0){
            df = new DecimalFormat("0.0000");
        } else {
            df = new DecimalFormat("#,###.0000");
        }
        return df.format(data);
    }

    public static void main(String[] args) {
        System.out.println(format2(new BigDecimal("0.123")));
    }
}
