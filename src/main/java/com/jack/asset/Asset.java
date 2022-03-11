package com.jack.asset;

import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/11/13:04
 */
public class Asset {
    public static BigDecimal sumOf20220311() {
        BigDecimal weChat = new BigDecimal("88252.63");
        BigDecimal lendMoney1 = new BigDecimal("2000");
        BigDecimal lendMoney2 = new BigDecimal("10000");
        BigDecimal lendMoney3 = new BigDecimal("5000");
        BigDecimal lendMoney4 = new BigDecimal("5000");
        return weChat.add(lendMoney1).add(lendMoney2).add(lendMoney3);
    }

    public static void main(String[] args) {
        BigDecimal total = sumOf20220311();
        // 105252.63
        System.out.println(total);
    }
}
