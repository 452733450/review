package com.jack.asset;

import java.math.BigDecimal;

public class Assert20240315 {
    public static void main(String[] args) {
        BigDecimal wechat = new BigDecimal("200170.17");
        BigDecimal lendMoney = new BigDecimal("12000");
        BigDecimal aliPay = new BigDecimal("1073.73");
        BigDecimal salary = new BigDecimal("12569");
        BigDecimal total = wechat.add(lendMoney).add(aliPay).add(salary);
        System.out.println(total);

        BigDecimal anticipatedIncome1 = new BigDecimal("18000");
        BigDecimal anticipatedIncome2 = new BigDecimal("15000").multiply(new BigDecimal("10"));
        BigDecimal anticipatedIncome3 = new BigDecimal("18000").multiply(new BigDecimal("3"));
        BigDecimal anticipatedBonus = new BigDecimal("18000");
        // 20250129过年
        BigDecimal allTotal = total.add(anticipatedIncome1).add(anticipatedIncome2).add(anticipatedIncome3).add(anticipatedBonus);
        System.out.println(allTotal);
    }
}
